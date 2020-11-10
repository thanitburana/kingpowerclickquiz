package com.quiz.kingpowerclickquiz.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(val items: ArrayList<T>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        render(holder, position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    abstract fun render(holder: RecyclerView.ViewHolder, position: Int)


    open class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {}
}