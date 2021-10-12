package com.example.simpledaggerhilt.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpledaggerhilt.data.BaseResource
import com.example.simpledaggerhilt.data.login.dto.LoginRequest
import com.example.simpledaggerhilt.data.login.dto.LoginResponse
import com.example.simpledaggerhilt.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
): ViewModel() {
    private val _loginData = MutableLiveData<BaseResource<LoginResponse>>()
    val loginData: LiveData<BaseResource<LoginResponse>> = _loginData

    init {
        Timber.d("LoginViewModel init.")
    }

   fun login(loginRequest: LoginRequest) {
        Timber.d("LoginViewModel login viewModelScope !")

       viewModelScope.launch {
           loginRepository.login(loginRequest).collect { result ->
               Timber.d("LoginViewModel > login() > result : {$result}")
               _loginData.value = result
           }
       }
   }

}