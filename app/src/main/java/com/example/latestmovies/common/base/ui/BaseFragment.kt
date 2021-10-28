package com.example.latestmovies.common.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.latestmovies.common.base.models.Resource
import com.example.latestmovies.common.base.state.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseFragment<T : BaseViewModel>() : Fragment() {

    protected lateinit var viewModel : T

    private var mViewModelFactory: ViewModelProvider.NewInstanceFactory? = null

    constructor(viewModelFactory: ViewModelProvider.NewInstanceFactory?) : this(){
        mViewModelFactory = viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(getContentViewId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = if (mViewModelFactory != null) {
            mViewModelFactory!!.create(getViewModelClass())
        } else {
            ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
            )[getViewModelClass()]
        }
        lifecycleScope.launch {
            viewModel.loadingState.collect { loadingState ->
                if(loadingState){
                    shouldShowLoading(loadingState)
                }
            }
        }
        viewModel.liveError().observe(viewLifecycleOwner, Observer { errorResource->
            errorResource?.let {
                if(errorResource is Resource.Failed){
                    showError(errorResource.message!!)
                }
            }
        })
    }


    open fun showError(errorMessage :String){
        Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
    }

    open fun shouldShowLoading(showLoading : Boolean){
        when(showLoading){
            true->{

            }
            false->{

            }
        }
    }

    abstract protected fun getViewModelClass() : Class<T>

    @LayoutRes
    abstract fun getContentViewId() : Int

}