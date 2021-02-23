package com.eunidev.stodeliterecytp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(val context: Context, val arrayList: ArrayList<Content>): RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.findViewById<TextView>(R.id.textViewTitle_CardView)
        val tvDescription = itemView.findViewById<TextView>(R.id.textViewDescription_CardView)

        fun bind(content: Content) {
            tvTitle.text = content.title
            tvDescription.text = content.descr
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_view, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = arrayList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int = arrayList.size

    fun deleteItem(pos: Int) {
        arrayList.removeAt(pos)
        notifyItemRemoved(pos)
    }
}