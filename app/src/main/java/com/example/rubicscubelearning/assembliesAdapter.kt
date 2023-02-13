package com.example.practicehelper

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rubicscubelearning.R

class AssembliesAdapter(private val assemblies:ArrayList<String>) : RecyclerView.Adapter<AssembliesAdapter.AssemblyViewHolder>(){

    inner class AssemblyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val assemblyTV: TextView = view.findViewById<View>(R.id.assemblyTV) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssemblyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.assemblies_item, parent, false)
        return AssemblyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AssemblyViewHolder, position: Int) {
        val assembly: String = assemblies[position]
        holder.assemblyTV.text = assembly

    }

    override fun getItemCount(): Int {
        return assemblies.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun confirmChanged(){
        notifyDataSetChanged()
    }
}