package com.example.simpledaggerhilt.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.simpledaggerhilt.data.login.dto.LoginRequest
import com.example.simpledaggerhilt.databinding.ActivityMainBinding
import com.example.simpledaggerhilt.ui.folder.FolderActivity
import com.example.simpledaggerhilt.ui.login.LoginActivity
import com.example.simpledaggerhilt.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goToLoginActivity()
    }

    private fun goToLoginActivity(){
        startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        finish()
    }

    private fun goToFolderActivity(){
        startActivity(Intent(this@MainActivity, FolderActivity::class.java))
        finish()
    }
}