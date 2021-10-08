package com.example.simpledaggerhilt.ui.folder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpledaggerhilt.data.BaseResource
import com.example.simpledaggerhilt.data.folder.dto.FolderResponse
import com.example.simpledaggerhilt.repository.FolderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class FolderViewModel @Inject constructor(
    private val folderRepository: FolderRepository
    ) : ViewModel() {

    private val _folderList = MutableLiveData<BaseResource<FolderResponse>>()
    val folderList: LiveData<BaseResource<FolderResponse>> = _folderList

    init {
        Timber.d("init FolderViewModel")
        fetchFolders()
    }

    private fun fetchFolders() {
        viewModelScope.launch {
            folderRepository.fetchFolderList().collect { result ->
                _folderList.value = result
            }
        }
    }

}