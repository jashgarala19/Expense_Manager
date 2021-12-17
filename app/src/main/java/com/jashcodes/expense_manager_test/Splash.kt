package com.jashcodes.expense_manager_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splash : AppCompatActivity() {
    private val SPLASH_SCREEN_TIME_OUT = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)



        supportActionBar?.hide()
        Handler().postDelayed(Runnable {
            val i = Intent(
                this@Splash,
                MainActivity::class.java
            )
            //Intent is used to switch from one activity to another.
            startActivity(i)
            //invoke the SecondActivity.
            finish()
            //the current activity will get finished.
        }, SPLASH_SCREEN_TIME_OUT.toLong())









    }
}