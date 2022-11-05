package com.example.myapplication.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Hobby
import com.example.myapplication.R
import com.example.myapplication.showToast
import kotlinx.android.synthetic.main.list_view.view.*

class HobbiesAdapter( val context: Context, private val hobbies:List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewholder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {
       val view= LayoutInflater.from(context).inflate(R.layout.list_view,parent,false)
        return MyViewholder(view)

    }
    override fun getItemCount(): Int {
        return hobbies.size

    }

    override fun onBindViewHolder(holder: MyViewholder, position: Int) {
        val hobby= hobbies[position]
        holder.setData(hobby,position)

    }
    inner class MyViewholder (itemView : View):RecyclerView.ViewHolder(itemView) {
        var currentHobby:Hobby? =null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                context.showToast(currentHobby!!.title+ "clicked")// Extension of showToast
               // Toast.makeText(context,currentHobby!!.title+ "clicked",Toast.LENGTH_SHORT).show()
            }
            itemView.imgShare.setOnClickListener {
                val message: String = "My Hobby is:"+currentHobby!!.title
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT,message)
                intent.type= "text/plain"
                context.startActivity(Intent.createChooser(intent,"Select the App:"))

            }
        }

        fun setData(hobby: Hobby?, position: Int) {
            hobby?.let {

                itemView.txvTitle.text = hobby.title
                this.currentHobby = hobby
                this.currentPosition= position

            }


        }
    }





}
