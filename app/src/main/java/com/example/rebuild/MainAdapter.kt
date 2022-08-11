package com.example.rebuild

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rebuild.databinding.AdapterMovieBinding

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {
    var movies = mutableListOf<Movie>()
    @JvmName("setMovies1")
    fun setMovieList(movies: List<Movie>){
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        var binding = AdapterMovieBinding.inflate(inflate,parent,false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.name.text = movie.name
        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)
    }
}
class MainViewHolder(val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {
}