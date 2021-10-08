package com.example.simpledaggerhilt.ui.folder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.simpledaggerhilt.data.BaseResource
import com.example.simpledaggerhilt.databinding.ActivityFolderBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class FolderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFolderBinding
    private val viewModel: FolderViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFolderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        subscribeUi()
    }

    private fun subscribeUi() {
        viewModel.folderList.observe(this, Observer { result ->
            when(result.status) {
                BaseResource.Status.SUCCESS -> {
                    result.data?.categoryList?.let {  list ->
                        Timber.d("FolderActivity > subscribeUi > subscribeUi() > list : ${list}")
                    }
                    binding.loading.visibility = View.GONE
                }

                BaseResource.Status.ERROR -> {
                    result.message?.let {
                        Timber.e(it)
                    }
                    binding.loading.visibility = View.GONE
                }

                BaseResource.Status.LOADING -> {
                    binding.loading.visibility = View.VISIBLE
                }
            }

        })
    }

}