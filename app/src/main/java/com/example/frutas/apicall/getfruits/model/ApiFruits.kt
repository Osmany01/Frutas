package com.example.frutas.apicall.getfruits.model

import com.example.frutas.controller.model.PresentationFruits

data class ApiFruits(var name: String)

fun ApiFruits.toPresentationFruit() = PresentationFruits( name = name)