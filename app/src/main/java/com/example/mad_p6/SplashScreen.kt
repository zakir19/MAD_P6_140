package com.example.mad_p6

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreen : AppCompatActivity(), Animation.AnimationListener {
    lateinit var guniAnimation: AnimationDrawable
    lateinit var tweenAnimation: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imgview = findViewById<ImageView>(R.id.imganimation)
        imgview.setBackgroundResource(R.drawable.uvpce_animation_list)
        guniAnimation = imgview.background as AnimationDrawable
        tweenAnimation = AnimationUtils.loadAnimation(this, R.anim.grow)
        tweenAnimation.setAnimationListener(this)
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            guniAnimation.start()
            findViewById<ImageView>(R.id.imganimation).startAnimation(tweenAnimation)
        } else {
            guniAnimation.stop()
        }
    }

    override fun onAnimationStart(p0: Animation?) {

    }

    override fun onAnimationEnd(p0: Animation?) {
        Intent(this, MainActivity::class.java).also{startActivity(it)}
    }

    override fun onAnimationRepeat(p0: Animation?) {

    }
}