package com.example.ecommerceapk.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapk.Domain.SearchDashClass
import com.example.ecommerceapk.R
import com.example.ecommerceapk.databinding.ViewholderFilterdashBinding
import com.example.ecommerceapk.databinding.ViewholderSerachdashbordBinding


class SearchDashAdapter(private val dataList: List<SearchDashClass>):
    RecyclerView.Adapter<SearchDashAdapter.ViewHolderClass>(){
    class ViewHolderClass(val binding: ViewholderSerachdashbordBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int  ): ViewHolderClass {
       val binding = ViewholderSerachdashbordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderClass(binding)

    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int  ) {
                val item = dataList[position]
                holder.binding.pic.setImageResource(item.pic)
                holder.binding.titleTxt.text = item.title
                holder.binding.CategoryTxt.text=item.category

    }

    override fun getItemCount(): Int {
       return dataList.size
    }


}