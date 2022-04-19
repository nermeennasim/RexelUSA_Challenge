package com.company.rexelusa_demo

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
var btnNavToSwapApi : Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //declare button and webview
        findViewById<Button>(R.id.btnGoToSwapApi).also { btnNavToSwapApi = it }
        val mWebView = findViewById<View>(R.id.webView) as WebView
        mWebView.loadUrl("https://www.rexelusa.com")
        val mWebSettings = mWebView.settings
        // mWebSettings.javaScriptEnabled = true
        mWebView.webViewClient = WebViewClient()
        mWebView.canGoBack()

        mWebView.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK && event.action == MotionEvent.ACTION_UP
                && mWebView.canGoBack()
            ) {
                mWebView.goBack()
                return@OnKeyListener true


            }
            return@OnKeyListener false

        })

        btnNavToSwapApi?.setOnClickListener {

            val intent = Intent(this@MainActivity, SwapApiActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}