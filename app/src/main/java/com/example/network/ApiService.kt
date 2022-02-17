package com.example.network

import com.example.model.PostModel
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
   suspend fun getPosts() : List<PostModel>
}