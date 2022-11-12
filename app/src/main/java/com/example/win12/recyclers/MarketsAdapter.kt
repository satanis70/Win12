package com.example.win12.recyclers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.win12.R
import com.example.win12.model.Tennismarket

class MarketsAdapter(val list: ArrayList<Tennismarket>) :
    RecyclerView.Adapter<MarketsAdapter.Holder>() {
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.findViewById<TextView>(R.id.text_view_title_market)
        val tvDefinition = itemView.findViewById<TextView>(R.id.text_view_definition_market)
        fun bind(title: String, definition: String) {
            tvTitle.text = title
            tvDefinition.text = definition
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.market_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position].name, list[position].definition)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}