package com.eee.homework3

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class CommentRestApi {


    companion object {
        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        fun getService () : CommentService {
            return retrofit.create(CommentService::class.java)
        }
    }
}