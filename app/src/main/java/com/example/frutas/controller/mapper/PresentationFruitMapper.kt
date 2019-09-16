package com.example.frutas.controller.mapper

import com.example.frutas.apicall.getfruits.model.ApiFruits
import com.example.frutas.apicall.getfruits.model.toPresentationFruit
import com.example.frutas.controller.model.PresentationFruits

class PresentationFruitMapper {

  fun mapApiFruit(apiFruits: List<ApiFruits>): List<PresentationFruits> {

      val presentationFruitsList  = ArrayList<PresentationFruits>()

      for(apiFruit: ApiFruits in apiFruits) {

          val presentationFruit: PresentationFruits = apiFruit.toPresentationFruit()
          presentationFruitsList.add(presentationFruit)
      }

      return presentationFruitsList
  }

}