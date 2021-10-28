package com.example.latestmovies.common.base.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.latestmovies.common.base.state.BaseViewModel
import com.example.latestmovies.common.base.models.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseActivity<T : BaseViewModel> : AppCompatActivity() {

    lateinit var _viewModel : T

    abstract protected fun getViewModelClass() : Class<T>

    @LayoutRes
    abstract fun getContentViewId() : Int

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        setContentView(getContentViewId())
        _viewModel = ViewModelProvider(this).get(getViewModelClass())

        lifecycleScope.launch {
            _viewModel.loadingState.collect {loadingState ->
                if(loadingState){
                    shouldShowLoading(loadingState)
                }
            }
        }
        _viewModel.liveError().observe(this, Observer { errorResource->
            errorResource?.let {
                if(errorResource is Resource.Failed){
                    showError(errorResource.message!!)
                }
            }
        })
        return super.onCreateView(name, context, attrs)
    }

    open fun showError(errorMessage :String){
        Toast.makeText(applicationContext, errorMessage, Toast.LENGTH_SHORT).show()
    }

    open fun shouldShowLoading(showLoading : Boolean){
        when(showLoading){
            true->{

            }
            false->{

            }
        }
    }

}