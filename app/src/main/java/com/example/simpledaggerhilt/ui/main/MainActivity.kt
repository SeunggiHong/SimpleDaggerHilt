package com.example.simpledaggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import com.example.simpledaggerhilt.data.login.dto.LoginRequest
import com.example.simpledaggerhilt.databinding.ActivityMainBinding
import com.example.simpledaggerhilt.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.*
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setTestUser()
        login()

    }

    private fun login() {
        binding.loginButton.setOnClickListener {
            val id = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()

            val loginRequest = LoginRequest(id, password, "web")
            viewModel.login(loginRequest)
            Timber.d("MainActivity login()")
        }
    }

    private fun setTestUser() {
        binding.testButton.setOnClickListener {
            binding.emailEditText.setText("textUser1")
            binding.passwordEditText.setText("test123")
        }
    }

}