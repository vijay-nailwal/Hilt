package com.example.Network

import com.example.Model.Post
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
   suspend fun getPosts() : List<Post>
}