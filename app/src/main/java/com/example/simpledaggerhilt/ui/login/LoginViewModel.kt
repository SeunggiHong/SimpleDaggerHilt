package com.example.simpledaggerhilt.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpledaggerhilt.data.BaseResult
import com.example.simpledaggerhilt.data.login.dto.LoginRequest
import com.example.simpledaggerhilt.data.login.dto.LoginResponse
import com.example.simpledaggerhilt.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
): ViewModel() {
    private val _baseBaseResult: MutableLiveData<BaseResult<List<LoginResponse>>> = MutableLiveData()
    val baseResult: LiveData<BaseResult<List<LoginResponse>>>
        get() = _baseBaseResult

    init {
        Timber.d("LoginViewModel init.")
    }

   fun login(loginRequest: LoginRequest) {
        Timber.d("LoginViewModel login viewModelScope !")
         viewModelScope.launch {
//             when(mainStat)
//             loginRepository.execute(loginRequest)
//                 .onEach { baseResult -> _baseResult.value = baseResult
//             }.launchIn(viewModelScope)
         }
    }

}

sealed class LoginStateEvent {
    object LoginEvents : LoginStateEvent()
    object None : LoginStateEvent()
}