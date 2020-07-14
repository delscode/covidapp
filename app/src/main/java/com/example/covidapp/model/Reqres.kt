package com.example.covidapp.model


import com.google.gson.annotations.SerializedName

data class Reqres(
    @SerializedName("country")
    val country: String,
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("total_province")
    val totalProvince: Int
)