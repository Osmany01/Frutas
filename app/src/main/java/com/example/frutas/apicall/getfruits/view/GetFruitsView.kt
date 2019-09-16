package com.example.frutas.apicall.getfruits.view

import com.example.frutas.apicall.getfruits.model.ApiFruits
import com.example.frutas.controller.model.PresentationFruits

interface GetFruitsView {

    fun onGetFruitsSuccess(result: ArrayList<PresentationFruits>)
    fun onGetFruitsFail(message: String)
    fun showLoader()
    fun hideLoader()
}