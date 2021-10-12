package com.example.simpledaggerhilt.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.simpledaggerhilt.R
import com.example.simpledaggerhilt.data.login.dto.LoginRequest
import com.example.simpledaggerhilt.databinding.ActivityLoginBinding
import com.example.simpledaggerhilt.databinding.ActivityMainBinding
import com.example.simpledaggerhilt.ui.folder.FolderActivity
import com.example.simpledaggerhilt.ui.grab.GrabActivity
import com.example.simpledaggerhilt.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setTestUser()
        login()
        goToFolderActivity()
        goToGrabActivity()
    }

    private fun login() {
        binding.loginButton.setOnClickListener {
            val id = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()

            val loginRequest = LoginRequest(id, password, "pc")
            viewModel.login(loginRequest)
            Timber.d("LoginActivity login()")
        }
    }

    private fun setTestUser() {
        binding.testButton.setOnClickListener {
            binding.emailEditText.setText("textUser")
            binding.passwordEditText.setText("test123")
        }
    }

    private fun goToFolderActivity(){
        binding.folderButton.setOnClickListener {
            startActivity(Intent(this@LoginActivity, FolderActivity::class.java))
            Timber.d("LoginActivity > goToFolderActivity()")
        }
    }

    private fun goToGrabActivity(){
        binding.grabButton.setOnClickListener {
            startActivity(Intent(this@LoginActivity, GrabActivity::class.java))
            Timber.d("LoginActivity > goToGrabActivity()")
        }
    }
}