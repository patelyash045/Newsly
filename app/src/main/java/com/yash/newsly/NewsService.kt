package com.yash.newsly

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//https://newsapi.org/v2/top-headlines?country=in&apiKey=API_KEY

//https://newsapi.org/v2/everything?q=tesla&from=2021-10-27&sortBy=publishedAt&apiKey=API_KEY

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "0f2b8c8984194bacac0910c1a95d4ad8"

interface NewsInterface{

    @GET("v2/top-headlines?apiKey$API_KEY")
    fun getHeadline(@Query("country")country: String,@Query("page") page: Int) : Call<News>


    //https://newsapi.org/v2/top-headlines?apiKey$API_KEY&country=in&page1
}

object NewsService{
    val newsInstance: NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)

    }
}

/*
object NewsService{
    val newsInstance: NewsInterface

    init {
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}
*/