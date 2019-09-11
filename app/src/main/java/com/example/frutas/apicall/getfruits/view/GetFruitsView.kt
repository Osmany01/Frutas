package com.example.frutas.apicall.getfruits.view

import com.example.frutas.apicall.getfruits.model.ApiFruits

interface GetFruitsView {

    fun onGetFruitsSuccess(result: ArrayList<ApiFruits>)
    fun onGetFruitsFail(message: String)
}