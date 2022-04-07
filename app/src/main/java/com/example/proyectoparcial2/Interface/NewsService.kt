package com.example.proyectoparcial2.Interface

import com.example.proyectoparcial2.Model.News
import com.example.proyectoparcial2.Model.WebSite
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface NewsService {

    @get:GET("v2/sources?apiKey=26052d861b7746c48bbf5b6f65b93dce")
    val sources: Call<WebSite>

    @GET
    fun getNewsFromSource(@Url url: String): Call<News>
}