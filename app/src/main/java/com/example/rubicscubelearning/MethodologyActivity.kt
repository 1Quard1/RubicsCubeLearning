package com.example.rubicscubelearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rubicscubelearning.databinding.ActivityMethodologyBinding

class MethodologyActivity : AppCompatActivity() {
    lateinit var binding: ActivityMethodologyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMethodologyBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun btCFOPOnClick(view: View){
        val intent = Intent(this,StageActivity::class.java)
        startActivity(intent)
    }
    fun btROUXOnClick(view: View){

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