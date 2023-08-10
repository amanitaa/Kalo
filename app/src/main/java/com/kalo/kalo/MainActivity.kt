package com.kalo.kalo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        val headers: MutableMap<String, String> = HashMap()
        headers["isMobApp"] = "true"

        webView.loadUrl(baseUrl, headers)

        bottomNavigation.selectedItemId = R.id.local_mall
        bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.local_mall -> {
                    webView.loadUrl(baseUrl, headers)
                    true
                }
                R.id.farmer -> {
                    webView.loadUrl("$baseUrl/კონსულტაცია/", headers)
                    true
                }
                R.id.info_hub -> {
                    webView.loadUrl("$baseUrl/my-account/", headers)
                    true
                }
                R.id.agro_news -> {
                    webView.loadUrl("$baseUrl/news/", headers)
                    true
                }
                R.id.agrometer -> {
                    webView.loadUrl("$baseUrl/აგრომეტრი/", headers)
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