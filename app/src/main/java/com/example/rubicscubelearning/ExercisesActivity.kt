package com.example.rubicscubelearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class ExercisesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercises)
    }

    fun btCrosswordsOnClick(view: View){
        val intent = Intent(this,CrosswordsActivity::class.java)
        startActivity(intent)
    }

    fun btLogicTasksOnClick(view: View){
        val intent = Intent(this,LogicTasksActivity::class.java)
        startActivity(intent)
    }

    fun btHomesOnClick(view: View){
        finish()
    }
}