package com.example.rubicscubelearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rubicscubelearning.databinding.ActivityMainBinding
import com.example.rubicscubelearning.databinding.ActivityTimerBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun btExercisesOnClick(view: View){
        val intent = Intent(this,ExercisesActivity::class.java)
        startActivity(intent)
    }

    fun btRubicsCubeOnClick(view: View){
        val intent = Intent(this,RubicsCubeActivity::class.java)
        startActivity(intent)
    }

    fun btTestOnClick(view: View){
        val intent = Intent(this,TestingActivity::class.java)
        startActivity(intent)
    }
}