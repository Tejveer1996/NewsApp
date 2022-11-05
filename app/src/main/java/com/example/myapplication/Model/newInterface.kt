package com.example.myapplication.Model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=in&apiKey=2069ba1ca20a4b5a84473dc0c97df1ca

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "2069ba1ca20a4b5a84473dc0c97df1ca"

interface NewsInterface{
//this function make the whole url for get request to send the webserver.
    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadline(@Query("country") country:String,@Query("page") Page:Int): Call<News>
}

// Object for retrofit
// make it singleton so whenever calling is made it will be done through single object

object NewServices{
    val newsInstance : NewsInterface

    init {
        val retrofit = Retrofit.Builder() // object of Retrofit
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java) // implementing NewsInterface in retrofit
    }
}