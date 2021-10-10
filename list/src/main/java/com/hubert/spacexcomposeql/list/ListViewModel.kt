package com.hubert.spacexcomposeql.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val listModel: ListModel) : ViewModel() {

    private val _items = MutableLiveData<List<LaunchItem>>()
    val items: LiveData<List<LaunchItem>> = _items

    fun getLaunches() {
        viewModelScope.launch {
            listModel.getLaunches().apply {
                _items.value = this
            }
        }
    }
}
