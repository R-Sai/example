package com.example.myapplication.data.net

import com.example.myapplication.domain.model.Facts
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Api {

    @GET("facts?limit=50")
    suspend fun getFacts(): Response<Facts>

    companion object {

        var BASE_URL = "https://catfact.ninja/"

        fun create(): Api {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(Api::class.java)

        }
    }
}