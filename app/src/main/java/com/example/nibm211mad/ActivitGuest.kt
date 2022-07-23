package com.example.nibm211mad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class ActivitGuest : AppCompatActivity(), AdapterView.OnItemSelectedListener {


    val mydata = arrayOf("iphone","Airpods","mac","apple Tv")
    lateinit var productSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activit_guest)

        productSpinner = findViewById(R.id.spnProduct)
        val arrayAdapter= ArrayAdapter(this,android.R.layout.simple_spinner_item,mydata)
        productSpinner.adapter=arrayAdapter

        productSpinner.onItemSelectedListener= this

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Toast.makeText(this,mydata[p2],Toast.LENGTH_SHORT).show()

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}