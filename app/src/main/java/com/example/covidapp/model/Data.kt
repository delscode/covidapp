package com.example.covidapp.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("fid")
    val fid: Int,
    @SerializedName("kasus_meni")
    val kasusMeni: Int,
    @SerializedName("kasus_posi")
    val kasusPosi: Int,
    @SerializedName("kasus_semb")
    val kasusSemb: Int,
    @SerializedName("kode_provi")
    val kodeProvi: Any,
    @SerializedName("provinsi")
    val provinsi: String
)