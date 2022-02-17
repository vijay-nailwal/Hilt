package com.example.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adapter.PostAdapter
import com.example.model.Post
import com.example.viewModel.PostViewModel
import com.example.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var postAdapter: PostAdapter
    private val postViewModel: PostViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUi()
        postViewModel.getPost()
        postViewModel.postLiveData.observe(this, Observer { response ->
            postAdapter.setData(response as ArrayList<Post>)
        })
    }

    private fun setUi() {
        postAdapter= PostAdapter(this, ArrayList())
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
    }
}