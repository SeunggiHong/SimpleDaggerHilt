package com.example.simpledaggerhilt.ui.grab

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpledaggerhilt.data.BaseResource
import com.example.simpledaggerhilt.data.folder.dto.FolderResponse
import com.example.simpledaggerhilt.data.grab.GrabResponse
import com.example.simpledaggerhilt.repository.GrabRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class GrabViewModel @Inject constructor(
    private val grabRepository: GrabRepository
    ) : ViewModel() {
    private val _allGrabList = MutableLiveData<BaseResource<GrabResponse>>()
    val allGrabList: LiveData<BaseResource<GrabResponse>> = _allGrabList

    init {
        Timber.d("init GrabViewModel")
        fetchAllGrabs()
    }

    private fun fetchAllGrabs() {
        viewModelScope.launch {
            grabRepository.fetchGrabAllList().collect { result ->
                _allGrabList.value = result
            }
        }
    }
}