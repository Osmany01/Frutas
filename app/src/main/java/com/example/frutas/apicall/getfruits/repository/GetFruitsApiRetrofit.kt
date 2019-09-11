package com.example.frutas.apicall.getfruits.repository

import com.example.frutas.apicall.getfruits.model.ApiFruits
import retrofit2.Call
import retrofit2.http.GET

interface GetFruitsApiRetrofit {

    @GET("fruits")
    fun getFruits() : Call<List<ApiFruits>>
}