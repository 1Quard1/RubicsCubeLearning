package com.example.rubicscubelearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rubicscubelearning.databinding.ActivityStageBinding

class StageActivity : AppCompatActivity() {
    lateinit var binding: ActivityStageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun btCrossOnClick(view: View){
        val intent = Intent(this,StageCrossActivity::class.java)
        startActivity(intent)
    }
    fun btF2LOnClick(view: View){
        val intent = Intent(this,StageFirstTwoLayerActivity::class.java)
        startActivity(intent)
    }
    fun btOLLOnClick(view: View){
        val intent = Intent(this,StageOLLActivity::class.java)
        startActivity(intent)
    }
    fun btPLLOnClick(view: View){
        val intent = Intent(this,StagePLLActivity::class.java)
        startActivity(intent)
    }
    fun btHomeOnClick(view: View){
        val i = Intent(applicationContext, MainActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        i.putExtra("EXIT", true)
        startActivity(i)
        finish()
    }
}