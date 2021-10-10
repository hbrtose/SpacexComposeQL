package com.hubert.spacexcomposeql.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val detailModel: DetailModel) : ViewModel() {

    private val _launch = MutableLiveData<DetailItem>()
    val launch: LiveData<DetailItem> = _launch

    fun getLaunch(id: Int) {
        viewModelScope.launch {
            detailModel.getDetail(id).apply {
                _launch.value = this
            }
        }
    }
}
