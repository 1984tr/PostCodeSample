package com.tr1984.postcodesample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.webkit.JavascriptInterface
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_post_code.*

class PostCodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_code)

        settingWebView()
        webview.loadUrl("https://fir-sample-aaf9e.web.app")
    }

    private fun settingWebView() {
        with(webview.settings) {
            javaScriptEnabled = true
            useWideViewPort = true
        }
        webview.addJavascriptInterface(PostCodeJavascriptInterface(), "PostCodeJavascriptInterface")
    }

    inner class PostCodeJavascriptInterface {

        @JavascriptInterface
        fun onSelectedAddress(addr: String?, extraAddr: String?, postCode: String?) {
            setResult(Activity.RESULT_OK, Intent().apply {
                putExtra("address", addr ?: "")
                putExtra("extraAddress", extraAddr ?: "")
                putExtra("postCode", postCode ?: "")
            })
            finish()
        }
    }
}
