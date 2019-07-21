package com.example.lifetotalmtg

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_customise.*

class CustomiseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customise)

        setPink.setOnClickListener {
            val intent = Intent()
            intent.putExtra("textColor", "Pink")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
