package com.example.proyectoparcial2.Common

import com.example.proyectoparcial2.Interface.NewsService
import com.example.proyectoparcial2.Remote.RetrofitClient

object Common {
    val BASE_URL = "https://newsapi.org/"
    val API_KEY = "26052d861b7746c48bbf5b6f65b93dce"

    val newsService:NewsService
        get() = RetrofitClient.getClient(BASE_URL).create(NewsService::class.java)

    fun getNewsAPI(source:String):String {
        val apiUrl = StringBuilder("https://newsapi.org/v2/top-headlines?sources=")
            .append(source)
            .append("&apiKey=")
            .append(API_KEY)
            .toString()
        return apiUrl
    }
}