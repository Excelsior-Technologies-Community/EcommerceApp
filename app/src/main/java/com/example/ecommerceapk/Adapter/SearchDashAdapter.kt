package com.example.ecommerceapk.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapk.Domain.SearchDashClass
import com.example.ecommerceapk.R


class SearchDashAdapter(private val dataList: List<SearchDashClass>):
    RecyclerView.Adapter<SearchDashAdapter.ViewHolderClass>(){
    class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView){

        val pic:ImageView = itemView.findViewById(R.id.pic)
        val title:TextView = itemView.findViewById(R.id.titleTxt)
        val category:TextView = itemView.findViewById(R.id.CategoryTxt)

    }
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int  ): ViewHolderClass {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_serachdashbord,parent,false)

        return ViewHolderClass(view)


    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int  ) {
                val item = dataList[position]
                holder.pic.setImageResource(item.pic)
                holder.title.text = item.title
                holder.category.text=item.category

    }

    override fun getItemCount(): Int {
       return dataList.size
    }


}