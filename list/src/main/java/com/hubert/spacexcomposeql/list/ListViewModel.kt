package com.hubert.spacexcomposeql.list

import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val listModel: ListModel) : ViewModel() {

    lateinit var items: MutableState<List<LaunchItem>>
    private set

    fun getLaunches() {
        viewModelScope.launch {
            listModel.getLaunches().apply {
                items.value = (items.value) + this
            }
        }
    }
}
