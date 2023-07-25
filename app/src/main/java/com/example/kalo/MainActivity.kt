package com.example.kalo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private lateinit var bottomNavigation: BottomNavigationView

    private var baseUrl: String = "https://kalo.ge/"


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.web_view)
        bottomNavigation = findViewById(R.id.bottom_navigation)

        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(baseUrl)

        bottomNavigation.selectedItemId = R.id.local_mall
        bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.local_mall -> {
                    webView.loadUrl(baseUrl)
                    true
                }
                R.id.farmer -> {
                    webView.loadUrl("$baseUrl/კონსულტაცია/")
                    true
                }
                R.id.info_hub -> {
                    webView.loadUrl("$baseUrl/my-account/")
                    true
                }
                R.id.agro_news -> {
                    webView.loadUrl("$baseUrl/news/")
                    true
                }
                R.id.agrometer -> {
                    webView.loadUrl("$baseUrl/აგრომეტრი/")
                    true
                }
                else -> false
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (webView.canGoBack())
            webView.goBack()
        else
            super.onBackPressed()
    }
}