package com.example.proyectoparcial2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoparcial2.Adapter.ViewHolder.MovieAdapter
import com.example.proyectoparcial2.Interface.MovieApiInterface
import com.example.proyectoparcial2.Interface.MovieApiService
import com.example.proyectoparcial2.Model.Movie
import com.example.proyectoparcial2.Model.MovieResponse
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.movies.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Movies : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movies)

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)
        getMovieData { movies : List<Movie> ->
            rv_movies_list.adapter = MovieAdapter(movies)
        }
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

        })
    }
}