package com.example.parcial_tapiavillanes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DivisaAdapter(private var lstDivisas:List<Divisa>): RecyclerView.Adapter<DivisaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val ivFlag: ImageView = itemView.findViewById(R.id.ivFlag)
        val tvSymbol: TextView = itemView.findViewById(R.id.tvSymbol)
        val tvCountry: TextView = itemView.findViewById(R.id.tvCountry)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_divisas, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemDivisa = lstDivisas[position]
        holder.tvSymbol.text = itemDivisa.symbol
        holder.tvCountry.text = itemDivisa.country
        holder.tvName.text = itemDivisa.name
        holder.ivFlag.setImageResource(itemDivisa.image)
    }

    override fun getItemCount(): Int {
        return lstDivisas.size
    }
}