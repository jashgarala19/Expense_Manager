package com.jashcodes.expense_manager_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)











        val Bottomnavigationview = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        Bottomnavigationview?.selectedItemId = R.id.settings
        Bottomnavigationview.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    Intent(this, MainActivity::class.java).apply {
                        startActivity(this)
                        overridePendingTransition(0, 0);
                    }
                    return@setOnItemSelectedListener true
                }
                R.id.calendar -> {
                    Intent(this, Calendar::class.java).apply {
                        startActivity(this)
                        overridePendingTransition(0, 0);
                    }
                    return@setOnItemSelectedListener true
                }
                R.id.stats -> {
                    Intent(this, Stats::class.java).apply {
                        startActivity(this)
                        overridePendingTransition(0, 0);
                    }
                    return@setOnItemSelectedListener true
                }
                else -> {
                    Intent(this, Settings::class.java).apply {
                        startActivity(this)
                        overridePendingTransition(0, 0);
                    }
                    return@setOnItemSelectedListener true
                }
            }
        }










    }
}