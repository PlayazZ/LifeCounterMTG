package com.example.lifetotalmtg

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var players = 4
    var health = 40

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val totalPlayers = findViewById<TextView>(R.id.totalPlayers)
        val totalHealth = findViewById<TextView>(R.id.totalHealth)
        updateTotals(totalPlayers, totalHealth)

        players1.setOnClickListener {
            players = 1
            updateTotals(totalPlayers, totalHealth)
        }

        players2.setOnClickListener {
            players = 2
            updateTotals(totalPlayers, totalHealth)
        }

        players3.setOnClickListener {
            players = 3
            updateTotals(totalPlayers, totalHealth)
        }

        players4.setOnClickListener {
            players = 4
            updateTotals(totalPlayers, totalHealth)
        }

        players5.setOnClickListener {
            players = 5
            updateTotals(totalPlayers, totalHealth)
        }

        players6.setOnClickListener {
            players = 6
            updateTotals(totalPlayers, totalHealth)
        }

        health20.setOnClickListener {
            health = 20
            updateTotals(totalPlayers, totalHealth)
        }

        health30.setOnClickListener {
            health = 30
            updateTotals(totalPlayers, totalHealth)
        }

        health40.setOnClickListener {
            health = 40
            updateTotals(totalPlayers, totalHealth)
        }

        start.setOnClickListener {
            startGame()
        }
    }

    private fun updateTotals(playersView: TextView, healthView: TextView) {
        playersView.apply{
            text = players.toString()
        }

        healthView.apply{
            text = health.toString()
        }
    }

    private fun startGame() {
        when(players) {
            1 -> {
                val intent = Intent(this, OnePlayerActivity::class.java).apply{
                    putExtra("PLAYERS", players)
                    putExtra("HEALTH", health)
                }
                startActivity(intent)
            }
            else -> println("Not setup yet")
        }
    }
}
