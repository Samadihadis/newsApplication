package com.hadis.newsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.google.gson.Gson
import com.hadis.newsapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import kotlin.math.log


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val newsList = mutableListOf<News>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        lifecycleScope.launch {
            binding.progressBar.isVisible = true
            val response = Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(API::class.java)
                .getNews("us", "2480c92d4b7a40c3ad46f1fe47e99a15")


            if (response.isSuccessful && response.body()!=null){
                //newsList.addAll(response.body()!!.articles)
                response.body()!!.articles.forEach {
                    val temp = it.author
                    if (!temp.isNullOrEmpty() && !temp.contains("href")){
                        newsList.add(it)
                    }
                }
                initialRecView()
                binding.progressBar.isVisible = false
            }else {
                Log.d("tagX", ": response failed")
            }
        }
    }

    private fun initialRecView() {
        val newsAdaptor = NewsAdaptor(newsList, this)
        val dividerItemDecoration = DividerItemDecoration(this , DividerItemDecoration.VERTICAL)
        with(binding.recyclerView) {
            adapter = newsAdaptor
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(dividerItemDecoration)
        }
    }


}