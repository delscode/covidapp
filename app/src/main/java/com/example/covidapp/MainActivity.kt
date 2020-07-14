package com.example.covidapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.covidapp.model.Data
import com.example.covidapp.model.Reqres
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val dataList: MutableList<Data> = mutableListOf()
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setup adapter
        myAdapter = MyAdapter(dataList)

        //setup recyclerview
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))
        recyclerView.adapter = myAdapter

        //setup Android Networking
        AndroidNetworking.initialize(this)
        AndroidNetworking.get("https://staging.ngorder.id/API/covid")
            .build()
            .getAsObject(Reqres::class.java, object : ParsedRequestListener<Reqres> {
                override fun onResponse(response: Reqres) {
                    dataList.addAll(response.data)
                    myAdapter.notifyDataSetChanged()
                }

                override fun onError(anError: ANError?) {
                }

            })
    }
}
