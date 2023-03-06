package com.example.assignment.retrofit

import com.example.assignment.model.ColorModel
import retrofit2.Response
import retrofit2.http.GET

interface ColorInterface {

    @GET("photos")
    suspend fun getColor() : Response<List<ColorModel>>

}