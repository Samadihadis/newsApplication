package com.hadis.newsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hadis.newsapplication.databinding.ActivityWebPageBinding

class WebPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.webView.loadUrl(intent.getStringExtra("url").orEmpty())
    }
}