package com.example.rubicscubelearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.rubicscubelearning.databinding.ActivityRubicsCubeBinding

class RubicsCubeActivity : AppCompatActivity() {
    lateinit var binding:ActivityRubicsCubeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRubicsCubeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun btLearningOnClick(view: View){
        val intent = Intent(this,LearningActivity::class.java)
        startActivity(intent)
    }

    fun btTimerOnClick(view: View){
        val intent = Intent(this,TimerActivity::class.java)
        startActivity(intent)
    }

    fun btHomeOnClick(view: View){
        finish()
    }

    fun btStatisticsOnClick(view: View){
        val intent = Intent(this,StatisticsActivity::class.java)
        startActivity(intent)
    }
}