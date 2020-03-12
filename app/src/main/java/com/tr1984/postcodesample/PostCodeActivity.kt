package com.tr1984.postcodesample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_post_code.*

class PostCodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_code)

        settingWebView()
        webview.loadUrl("")
    }

    private fun settingWebView() {

    }
}
