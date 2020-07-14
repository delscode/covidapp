package com.example.covidapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.covidapp.model.Data
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

class MyAdapter (private val dataList: MutableList<Data>) : RecyclerView.Adapter<MyHolder>(){

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        context = parent.context
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val data = dataList[position]

        val userProvinsiNameTextView = holder.itemView.provinsi_name
        val userKasusSembuhTextView = holder.itemView.kasus_sembuh
        val userKasusPositifTextView = holder.itemView.kasus_positif
        val userKasusMeninggalTextView = holder.itemView.kasus_meninggal

        val namaProvinsi = "${data.provinsi}"
        val kasusSembuh = "Kasus Sembuh       : ${data.kasusSemb}"
        val kasusPositif = "Kasus Positif          : ${data.kasusPosi}"
        val kasusMeninggal = "Kasus Meninggal   : ${data.kasusMeni}"
        userProvinsiNameTextView.text = namaProvinsi
        userKasusSembuhTextView.text = kasusSembuh
        userKasusPositifTextView.text = kasusPositif
        userKasusMeninggalTextView.text = kasusMeninggal

        Picasso.get()
            .load(data.fid)

        holder.itemView.setOnClickListener {
            Toast.makeText(context, namaProvinsi, Toast.LENGTH_SHORT).show()
        }
    }
}