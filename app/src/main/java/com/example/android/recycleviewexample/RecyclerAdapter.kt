package com.example.android.recycleviewexample

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.textview_layout.view.*

class RecyclerAdapter(val context: Context, val items: List<String>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.textview_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.textviewMessage.text = items[position]

        holder.setData(items[position], position)

        holder.itemView.setOnClickListener{
            Toast.makeText(context, "${items[position]} was clicked", Toast.LENGTH_LONG).show()
        }
    }


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var item : String? = null
        var p: Int = 0

        fun setData(s: String, position: Int) {

            itemView.textviewMessage.text = s
            item = s
            p = position
        }

        init {
            view.imgShare.setOnClickListener{
                item?.let {
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, "My hobby is ${item}")
                    intent.type = "Text/plain"

                    context.startActivity(Intent.createChooser(intent, "Choose app to share hobby:"))
                }
            }

            view.imgDisplay.setOnClickListener {
                Cache.imageId = R.drawable.canada
                val intent = Intent(context, DisplayImageActivity::class.java)
                startActivity(context, intent, null)
            }
        }
    }

}