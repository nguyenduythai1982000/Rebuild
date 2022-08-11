package com.example.rebuild

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rebuild.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
        val TAG = "MainActivity"
        private lateinit var binding: ActivityMainBinding
        private lateinit var viewModel: MainViewModel
        val retrofitService = RetrofitService.getInstance()
        val adapter = MainAdapter()
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)
            binding.recyclerview.adapter = adapter
            viewModel.movieList.observe(this, Observer {
                Log.d(TAG, "onCreate: $it")
                adapter.setMovieList(it)
            })
            viewModel.errorMessage.observe(this, Observer {
            })
            viewModel.getAllMovies()
        }

    }


