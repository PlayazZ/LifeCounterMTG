package com.example.lifetotalmtg

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_one_player.*

class OnePlayerActivity : AppCompatActivity() {
    var lifeTotal = 40
    var textColour = Color.RED
    var textColourString = "Red"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_one_player)

        lifeTotal = intent.getIntExtra("HEALTH", 40)

        val healthView = findViewById<TextView>(R.id.lifeTotal).apply{
            text = lifeTotal.toString()
        }

        minus.setOnClickListener {
            setLife(false, false, healthView)
        }

        plus.setOnClickListener {
            setLife(true, false, healthView)
        }

        plus.setOnLongClickListener {
            setLife(true, true, healthView)
        }

        minus.setOnLongClickListener {
            setLife(false, true, healthView)
        }

        healthView.setOnClickListener {
            val intent = Intent(this, CustomiseActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    fun setColours(colour : String) {
        val healthView = findViewById<TextView>(R.id.lifeTotal).apply{
            text = lifeTotal.toString()
        }
        when(colour) {
            "Pink" -> {
                healthView.setTextColor(Color.MAGENTA)
            }
            else -> println("Not Set Yet")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) textColourString = data?.getStringExtra("textColor") ?: "Red"
            setColours(textColourString)
        }
    }
    private fun setLife(plus: Boolean, long: Boolean,  healthView: TextView): Boolean {
        if (plus) {
            if (long) {
                lifeTotal+=10
            } else {
                lifeTotal++
            }
        } else {
            if (long) {
                lifeTotal-=10
            } else {
                lifeTotal--
            }
        }
        healthView.apply{
            text = lifeTotal.toString()
        }
        return true
    }
}
