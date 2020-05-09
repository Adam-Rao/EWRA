package com.kareh.ewraapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kareh.ewraapp.R
import com.kareh.ewraapp.models.BankItem
import com.squareup.picasso.Picasso

class BankFragmentAdapter(private val items: MutableList<BankItem>) : RecyclerView.Adapter<BankFragmentAdapter.BankFragmentAdapterViewHolder>() {

    class BankFragmentAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardImage = itemView.findViewById<ImageView>(R.id.bank_card_image)!!
        var cardText = itemView.findViewById<TextView>(R.id.bank_card_title)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankFragmentAdapterViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.bank_recyclerview_item, parent, false)
        return BankFragmentAdapterViewHolder(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BankFragmentAdapterViewHolder, position: Int) {
        val item = items[position]
        holder.cardText.text = item.cardText
        Picasso.get().load(item.imageRes).fit().into(holder.cardImage)
    }

}