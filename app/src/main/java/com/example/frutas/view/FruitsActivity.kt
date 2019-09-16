package com.example.frutas.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.frutas.R
import com.example.frutas.apicall.getfruits.model.ApiFruits
import com.example.frutas.apicall.getfruits.view.GetFruitsView
import com.example.frutas.controller.FruitsController
import com.example.frutas.controller.model.PresentationFruits
import com.example.frutas.view.adapter.FruitAdapter
import kotlinx.android.synthetic.main.fruits_layout.*

class FruitsActivity : AppCompatActivity(), GetFruitsView {

    private lateinit var mController : FruitsController

    //endregion
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fruits_layout)

        mController = FruitsController(this)

        initUI()
    }

    fun initUI() {

        buttonGetFruits.setOnClickListener{

            mController.getFruits()
        }
    }
    //region CallBack
    override fun onGetFruitsSuccess(result: ArrayList<PresentationFruits>) {

        hideLoader()
        initRecyclerView(result)
    }

    override fun onGetFruitsFail(message: String) {

        hideLoader()
        recyclerViewFruits.visibility = View.GONE
        tvErrorMessage.visibility = View.VISIBLE
    }
    //endregion

    //region UI Helper

    fun initRecyclerView(result: ArrayList<PresentationFruits>) {

        recyclerViewFruits.visibility = View.VISIBLE
        tvErrorMessage.visibility = View.GONE

        recyclerViewFruits.layoutManager = LinearLayoutManager(this)
        recyclerViewFruits.adapter = FruitAdapter(result, this)

    }

    override fun showLoader() {

        progress_bar.visibility = View.VISIBLE
    }

    override fun hideLoader() {

        progress_bar.visibility = View.GONE
    }
    //endregion
}