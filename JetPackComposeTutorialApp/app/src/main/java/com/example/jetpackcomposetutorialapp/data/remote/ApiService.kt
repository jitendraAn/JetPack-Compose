package com.example.jetpackcomposetutorialapp.data.remote

import com.example.jetpackcomposetutorialapp.data.model.Post
import retrofit2.http.GET

interface ApiService {
    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    @GET("posts")
    suspend fun getPost():List<Post>

}