package com.example.ecommerceapk.Adapter

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
        val category:TextView = itemView.findViewById<(R.id.CategoryTxt)


    }
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int  ): ViewHolderClass {

    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int  ) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}