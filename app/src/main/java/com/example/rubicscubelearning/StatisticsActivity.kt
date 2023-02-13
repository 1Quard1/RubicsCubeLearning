package com.example.rubicscubelearning

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicehelper.AssembliesAdapter
import com.example.rubicscubelearning.databinding.ActivityStatisticsBinding

class StatisticsActivity : AppCompatActivity() {
    lateinit var binding: ActivityStatisticsBinding
    lateinit var pref :SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatisticsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pref = getSharedPreferences("ASSEMBLIES", MODE_PRIVATE)
        createListOfAssemblies()
    }
    fun createListOfAssemblies(){
        binding.assembliesRV.layoutManager = GridLayoutManager(this@StatisticsActivity,2)
        val assemblies = ArrayList<String>()
        val numberOfAssembly = pref.getInt("numberOfAssembly",0)
        var count = 1
        var assembly = ""
        while (assemblies.size < numberOfAssembly - 1){
            Log.d("myLog","$count, $assembly,$assemblies")
            assembly = pref.getString("assembly$count","0").toString()
            assemblies.add(assembly)
            count++
        }
        val adapter = AssembliesAdapter(assemblies)
        binding.assembliesRV.adapter = adapter
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