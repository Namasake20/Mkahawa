package com.namasake.mkahawa.framework.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.namasake.mkahawa.business.domain.model.Restaurant
import com.namasake.mkahawa.business.domain.state.DataState
import com.namasake.mkahawa.business.interactors.GetRestaurants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRestaurants: GetRestaurants,
    private val savedStateHandle: SavedStateHandle
) :ViewModel(){

    private val _dataState:MutableLiveData<DataState<List<Restaurant>>> = MutableLiveData()
    val dataState: LiveData<DataState<List<Restaurant>>>
    get() = _dataState

    fun setStateEvent(mainStateEvent:MainStateEvent){
        viewModelScope.launch {
            when(mainStateEvent){
                is MainStateEvent.GetRestaurantsEvent -> {
                    getRestaurants.execute().onEach { dataState ->
                        _dataState.value = dataState
                    }.launchIn(viewModelScope)
                }
            }
        }

    }

}
sealed class MainStateEvent{

    object GetRestaurantsEvent: MainStateEvent()

    object None: MainStateEvent()
}
