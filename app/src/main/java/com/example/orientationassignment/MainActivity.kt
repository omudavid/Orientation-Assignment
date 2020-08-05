package com.example.orientationassignment

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var state = "onCreate"
    var portraitCount = 0
    var landScapeCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var run  = Runnable {
            tvStates.text = "ON CREATE"
        }
        var hand = Handler()
        hand.postDelayed(run , 1000)

        if(savedInstanceState==null){
            if(resources.configuration.orientation== Configuration.ORIENTATION_LANDSCAPE){
                tvOrientation.text = "LANDSCAPE $landScapeCount"
            }else{
                tvOrientation.text = "PORTRAIT $portraitCount"
            }
        }

        if (savedInstanceState != null) {
            landScapeCount = savedInstanceState.getInt("LANDSCAPE_COUNT")
            portraitCount = savedInstanceState.getInt("PORTRAIT_COUNT")


            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                landScapeCount++
                tvOrientation.text = "LANDSCAPE $landScapeCount"
            } else {
                portraitCount++
                tvOrientation.text = "PORTRAIT $portraitCount"
            }
        }

        btnGoToFragmentActivity.setOnClickListener {
            Intent(this,FragmentActivity::class.java).also{
                startActivity(it)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        var run  = Runnable {
            tvStates.text = "ON START"
        }
        var hand = Handler()
        hand.postDelayed(run , 1000)
    }

    override fun onResume() {
        super.onResume()
        var run  = Runnable {
            tvStates.text = "ON RESUME"
        }
        var hand = Handler()
        hand.postDelayed(run , 1000)
    }

    override fun onRestart() {
        super.onRestart()
        var run  = Runnable {
            tvStates.text = "ON RESTART"
        }
        var hand = Handler()
        hand.postDelayed(run , 1000)
    }

    override fun onPause() {
        super.onPause()
        var run  = Runnable {
            tvStates.text = "ON Pause"
        }
        var hand = Handler()
        hand.postDelayed(run , 1000)
    }

    override fun onStop() {
        super.onStop()
        var run  = Runnable {
            tvStates.text = "ON STOP"
        }
        var hand = Handler()
        hand.postDelayed(run , 1000)
    }

    override fun onDestroy() {
        super.onDestroy()
        var run  = Runnable {
            tvStates.text = "ON Destroy"
        }
        var hand = Handler()
        hand.postDelayed(run , 1000)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("PORTRAIT_COUNT",portraitCount)
        outState.putInt("LANDSCAPE_COUNT",landScapeCount)

    }
}