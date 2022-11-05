package com.example.myapplication.Activities

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val url = intent.getStringExtra("URL")
        if (url!=null){
            detailWebView.settings.javaScriptEnabled = true // enable any of the javaScript present in the URL
            // userAgentString tells the server from where the call is coming like desktop or phone
            detailWebView.settings.userAgentString = "Mozilla/5.0 (iPhone; CPU iPhone OS 13_5_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.1.1 Mobile/15E148 Safari/604.1"
            detailWebView.webViewClient = object: WebViewClient(){  // page load event hiding the progressBar
                                                                       // after loading of url and giving visibility to webView
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    progressBar.visibility= View.GONE
                    detailWebView.visibility = View.VISIBLE
                }

            }
            detailWebView.loadUrl(url)
        }

    }
}