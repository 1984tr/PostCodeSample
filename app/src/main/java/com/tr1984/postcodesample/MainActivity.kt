package com.tr1984.postcodesample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1000 -> {
                if (resultCode == Activity.RESULT_OK) {
                    data?.run {
                        val address = getStringExtra("address") ?: ""
                        val extraAddress = getStringExtra("extraAddress") ?: ""
                        val postCode = getStringExtra("postCode") ?: ""
                        result.text = "$address $extraAddress $postCode"
                    }
                }
            }
        }
    }

    fun goToPostCodeWeb(v: View) {
        startActivityForResult(Intent(this@MainActivity, PostCodeActivity::class.java), 1000)
    }
}
