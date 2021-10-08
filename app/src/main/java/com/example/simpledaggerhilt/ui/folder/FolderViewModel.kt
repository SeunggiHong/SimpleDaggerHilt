package com.example.simpledaggerhilt.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpledaggerhilt.data.BaseResult
import com.example.simpledaggerhilt.data.folder.dto.FolderResponse
import com.example.simpledaggerhilt.repository.FolderRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class FolderViewModel @Inject constructor(private val folderRepository: FolderRepository) : ViewModel() {

    private val _folderList = MutableLiveData<BaseResult<FolderResponse>>()
    val folderList: LiveData<BaseResult<FolderResponse>> = _folderList

    init {
        Timber.d("init FolderViewModel")
    }

    private fun fetchFolders() {
        viewModelScope.launch {
            folderRepository.fetchFolderList().collect {
                _folderList.value = it
            }
        }
    }

}