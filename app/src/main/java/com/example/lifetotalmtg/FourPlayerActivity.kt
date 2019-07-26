package com.example.lifetotalmtg

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_four_player.*
import kotlinx.android.synthetic.main.activity_one_player.view.*

class FourPlayerActivity : AppCompatActivity() {
    var startingHealth = 40
    var healthArray = arrayOf(40, 40, 40, 40)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_four_player)

        startingHealth = intent.getIntExtra("HEALTH", 40)
        healthArray[0] = startingHealth
        healthArray[1] = startingHealth
        healthArray[2] = startingHealth
        healthArray[3] = startingHealth

        val player1HealthView = findViewById<TextView>(R.id.player1life).apply{
            text = healthArray[0].toString()
        }

        val player2HealthView = findViewById<TextView>(R.id.player2life).apply{
            text = healthArray[1].toString()
        }

        val player3HealthView = findViewById<TextView>(R.id.player3life).apply{
            text = healthArray[2].toString()
        }

        val player4HealthView = findViewById<TextView>(R.id.player4life).apply{
            text = healthArray[3].toString()
        }

        player1minus.setOnClickListener {
            setLife(false, false, player1HealthView, 1)
        }

        player2minus.setOnClickListener {
            setLife(false, false, player2HealthView, 2)
        }

        player3minus.setOnClickListener {
            setLife(false, false, player3HealthView, 3)
        }

        player4minus.setOnClickListener {
            setLife(false, false, player4HealthView, 4)
        }

        player1plus.setOnClickListener {
            setLife(true, false, player1HealthView, 1)
        }

        player2plus.setOnClickListener {
            setLife(true, false, player2HealthView, 2)
        }

        player3plus.setOnClickListener {
            setLife(true, false, player3HealthView,3)
        }

        player4plus.setOnClickListener {
            setLife(true, false, player4HealthView,4)
        }

        player1plus.setOnLongClickListener {
            setLife(true, true, player1HealthView,1)
        }

        player2plus.setOnLongClickListener {
            setLife(true, true, player2HealthView,2)
        }

        player3plus.setOnLongClickListener {
            setLife(true, true, player3HealthView,3)
        }

        player4plus.setOnLongClickListener {
            setLife(true, true, player4HealthView,4)
        }

        player1minus.setOnLongClickListener {
            setLife(false, true, player1HealthView,1)
        }

        player2minus.setOnLongClickListener {
            setLife(false, true, player2HealthView,2)
        }

        player3minus.setOnLongClickListener {
            setLife(false, true, player3HealthView,3)
        }

        player4minus.setOnLongClickListener {
            setLife(false, true, player4HealthView,4)
        }
    }

    private fun setLife(plus: Boolean, long: Boolean,  healthView: TextView, player: Int): Boolean {
        val index = player - 1
        if (plus) {
            if (long) {
                healthArray[index]+=10
            } else {
                healthArray[index]++
            }
        } else {
            if (long) {
                healthArray[index]-=10
            } else {
                healthArray[index]--
            }
        }
        healthView.apply{
            text = healthArray[index].toString()
        }
        return true
    }
}
