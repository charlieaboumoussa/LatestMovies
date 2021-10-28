package com.example.latestmovies.common.base.state

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.latestmovies.common.base.models.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

open class BaseViewModel : ViewModel() {

    // Using Flow and LiveData examples
    private val _loadingState = MutableStateFlow(true)
    val loadingState: StateFlow<Boolean> = _loadingState

    private val _liveError : SingleLiveEvent<Resource<String>> = SingleLiveEvent()

    fun showError(errorMessage : String){
        _liveError.value = Resource.Failed(errorMessage)
    }

    fun liveError() : LiveData<Resource<String>>{
        return _liveError
    }

}