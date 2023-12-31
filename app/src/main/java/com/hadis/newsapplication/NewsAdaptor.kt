package com.hadis.newsapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdaptor(var newsList: List<News> , var context : Context) :
    RecyclerView.Adapter<NewsAdaptor.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val description: TextView
        val dateAndAuthor: TextView
        val image: ImageView

        init {
            view.apply {
                title = findViewById(R.id.titleTextView)
                description = findViewById(R.id.descriptionTextView)
                dateAndAuthor = findViewById(R.id.dateAndAuthorTextView)
                image = findViewById(R.id.avatarImageView)

                title.setOnClickListener {
                    val intent = Intent(context , WebPageActivity::class.java)
                    intent.putExtra("url" , newsList[adapterPosition].url)
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_schema, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            title.text = newsList[position].title
            description.text = newsList[position].description
            dateAndAuthor.text = newsList[position].publishedAt + "\n" + newsList[position].author
            Glide.with(context).load(newsList[position].urlToImage).into(image)
        }

    }
}