package com.example.nibm211mad

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.RequestFuture
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import org.json.JSONObject

class weather : AppCompatActivity() {

     lateinit var txtdescription : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        txtdescription = findViewById(R.id.txt_1)
        //iageView = findViewById(R.id.img_View)

        getWeatherDetails("Colombo")
    }

    fun getWeatherDetails(city:String){
        val url="https://api.openweathermap.org/data/2.5/weather?q=colombo&appid=c722f9442601572e91a30613c4fd7f87"
        var request = StringRequest(Request.Method.GET,url, { response ->
            Log.e("Response", response)

            try{
                val json =JSONObject(response)
                val weatherArray = json.getJSONArray("weather")
                val weatherDataObject = weatherArray.get(0) as JSONObject
                val description = weatherDataObject.get("description").toString()
                txtdescription.setText(description)

                val main = json.getJSONObject("main")
                val temp =  main.get("temp")

                val iconCode = weatherDataObject.getString("icon")
                val imageURL = "http://openweathermap.org/img/w/" +iconCode+ ".png"

              //  Glide.with(this).load(imageURL).centerCrop().into(imageView)

            }
            catch (e :Exception){

            }

        },{ error ->
            Log.e("Response", error.toString())
        })
       // Volley.newRequestQueue(applicationContext.add(request))

        Volley.newRequestQueue(applicationContext).add(request)
    }
}