package com.example.ViewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Model.Post
import com.example.Repository.PostRepository
import com.example.Utils.LogUtil
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PostViewModel @ViewModelInject constructor(private val postRepository: PostRepository) :
    ViewModel() {
    val postLiveData: MutableLiveData<List<Post>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            postRepository.getPost()
                .catch { e ->
                    LogUtil.d("getPost: ${e.message}")
                }.collect { response ->
                    postLiveData.value = response
                }

        }
    }
}