package com.example.simpledaggerhilt.ui.grab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.simpledaggerhilt.R
import com.example.simpledaggerhilt.data.BaseResource
import com.example.simpledaggerhilt.databinding.ActivityGrabBinding
import com.example.simpledaggerhilt.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class GrabActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGrabBinding
    private val viewModel: GrabViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGrabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        subscribeUi()
    }

    private fun subscribeUi() {
        viewModel.allGrabList.observe(this, Observer { result ->
            when(result.status) {
                BaseResource.Status.SUCCESS -> {
                    result.data?.memoList?.let {  list ->
                        Timber.d("FolderActivity > subscribeUi > subscribeUi() > list : ${list}")
                    }
//                    binding.loading.visibility = View.GONE
                }

                BaseResource.Status.ERROR -> {
                    result.message?.let {
                        Timber.e(it)
                    }
//                    binding.loading.visibility = View.GONE
                }

                BaseResource.Status.LOADING -> {
//                    binding.loading.visibility = View.VISIBLE
                }
            }

        })
    }
}