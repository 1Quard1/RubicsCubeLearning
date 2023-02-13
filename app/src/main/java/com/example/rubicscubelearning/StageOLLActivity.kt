package com.example.rubicscubelearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class StageOLLActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stage_oll)
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