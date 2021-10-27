package com.example.latestmovies.base

import SingleLiveEvent
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.latestmovies.base.models.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

open class BaseViewModel : ViewModel() {

    // Backing property to avoid state updates from other classes
    private val _loadingState = MutableStateFlow(true)
    // The UI collects from this StateFlow to get its state updates
    val loadingState: StateFlow<Boolean> = _loadingState

    private val _liveError : SingleLiveEvent<Resource<String>> = SingleLiveEvent()

    fun showError(errorMessage : String){
        _liveError.value = Resource.Failed(errorMessage)
    }

    fun liveError() : LiveData<Resource<String>>{
        return _liveError
    }

}