package com.example.orientationassignment

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var state = "onCreate"
    var portraitCount = 0
    var landScapeCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvStates.text = "OnCreate"
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
        tvStates.text = "OnStart"
    }

    override fun onResume() {
        super.onResume()
        tvStates.text = "OnResume"
    }

    override fun onRestart() {
        super.onRestart()
        tvStates.text = "OnRestart"
    }

    override fun onPause() {
        super.onPause()
        tvStates.text = "OnPause"
    }

    override fun onStop() {
        super.onStop()
        tvStates.text = "OnStop"
    }

    override fun onDestroy() {
        super.onDestroy()
        tvStates.text = "OnDestroy"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("PORTRAIT_COUNT",portraitCount)
        outState.putInt("LANDSCAPE_COUNT",landScapeCount)

    }
}