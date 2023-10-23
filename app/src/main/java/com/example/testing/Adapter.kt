package com.example.testing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide



class Adapter(val dogList: MutableList<String>,val userNames: List<String>,val Likes: List<String>): RecyclerView.Adapter<Adapter.DogViewHolder>() {
    class DogViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val Image: ImageView
        val userTextView: TextView
        val likesTextView: TextView

        init {
            Image = view.findViewById(R.id.photo)
            userTextView = view.findViewById(R.id.user)
            likesTextView = view.findViewById(R.id.likes)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return DogViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dogList.size
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val userName = userNames.getOrNull(position) ?: holder.itemView.context.getString(R.string.default_user_name)
        val Likes = Likes.getOrNull(position) ?: holder.itemView.context.getString(R.string.default_like_count)
        Glide.with(holder.itemView)
            .load(dogList[position])
            .centerCrop()
            .into(holder.Image)

            holder.userTextView.text = "User: $userName"
            holder.likesTextView.text = "Likes: $Likes"







    }
}