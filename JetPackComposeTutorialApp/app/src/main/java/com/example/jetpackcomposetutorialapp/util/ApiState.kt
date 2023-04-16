package com.example.jetpackcomposetutorialapp.util

import com.example.jetpackcomposetutorialapp.data.model.Post

sealed class ApiState{

    class Success(val data:List<Post> ) : ApiState()
    class Failure(val msg:Throwable) : ApiState()
    object Loading : ApiState()
    object Empty : ApiState()

}