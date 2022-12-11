package com.eee.homework3


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CommentService {
    @GET ("/comments")
    fun getAll(): Call<List<CommentResponse>>

    @GET("/comments/{id}")
    fun getById(@Path("id") id: Int) : Call<CommentResponse>

    @POST("/comments")
    fun insert(@Body commentResponse: CommentResponse) : Call<CommentResponse>

}