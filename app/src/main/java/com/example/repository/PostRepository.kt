package com.example.repository

import com.example.model.PostModel
import com.example.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostRepository @Inject constructor(private val apiService: ApiService) {

    fun getPost() : Flow<List<PostModel>> = flow {
        val response= apiService.getPosts()
        emit(response)
    }.flowOn(Dispatchers.IO)
}