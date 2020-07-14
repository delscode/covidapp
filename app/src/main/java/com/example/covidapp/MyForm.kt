package com.example.covidapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.form.*
import org.json.JSONObject

class MyForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form)

        val viewBtn = findViewById(R.id.btnformpantau) as Button
        val saveBtn = findViewById(R.id.btnformsimpan) as Button
        val editProvinsi = findViewById(R.id.etProvinsi) as EditText
        val editPositif = findViewById(R.id.etPositif) as EditText
        val editSembuh = findViewById(R.id.etSembuh) as EditText
        val editMeninggal = findViewById(R.id.etMeninggal) as EditText

        AndroidNetworking.initialize(getApplicationContext())
        saveBtn.setOnClickListener {
            AndroidNetworking.post("https://staging.ngorder.id/API/covidinsert")
                .addBodyParameter("provinsi", editProvinsi.text.toString())
                .addBodyParameter("kasus_posi", editPositif.text.toString())
                .addBodyParameter("kasus_meni", editMeninggal.text.toString())
                .addBodyParameter("kasus_semb", editSembuh.text.toString())
                .setTag("Posting")
                .build()
                .getAsJSONObject(object  : JSONObjectRequestListener{
                    override fun onResponse(response: JSONObject?) {
                        Toast.makeText(this@MyForm, "success sending data", Toast.LENGTH_SHORT).show()
                    }

                    override fun onError(anError: ANError?) {
                        Toast.makeText(this@MyForm,"failed", Toast.LENGTH_SHORT).show()
                    }
                })
        }

        btnformpantau.setOnClickListener() {
            startActivity(Intent(this, MainActivity::class.java))

        }
    }

}