package com.example.frutas.controller

import com.example.frutas.apicall.getfruits.model.ApiFruits
import com.example.frutas.apicall.getfruits.repository.GetFruitsApiRetrofit
import com.example.frutas.apicall.getfruits.view.GetFruitsView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FruitsController(val getFruitsView: GetFruitsView) {

    fun getFruits() {

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://private-92b860-testfrutas.apiary-mock.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service : GetFruitsApiRetrofit = retrofit.create<GetFruitsApiRetrofit>(GetFruitsApiRetrofit::class.java)

        service.getFruits().enqueue(object: Callback<List<ApiFruits>> {
            override fun onResponse(call: Call<List<ApiFruits>>?, response: Response<List<ApiFruits>>?) {

                val result = response?.body()
                if (result != null) {

                    getFruitsView.onGetFruitsSuccess(result as ArrayList<ApiFruits>)
                }
            }
            override fun onFailure(call: Call<List<ApiFruits>>?, t: Throwable?) {
                t?.printStackTrace()

                getFruitsView.onGetFruitsFail(t?.message.toString())
            }
        })
    }
}