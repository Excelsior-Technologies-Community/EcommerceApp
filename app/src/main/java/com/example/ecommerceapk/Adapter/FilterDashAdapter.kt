package com.example.ecommerceapk.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapk.Domain.FilterDashClass
import com.example.ecommerceapk.R
import com.example.ecommerceapk.databinding.ViewholderFilterdashBinding

class FilterDashAdapter(  private val dataList: List<FilterDashClass>
) : RecyclerView.Adapter<FilterDashAdapter.ViewHolderClass>() {
    private var selectedPosition:Int =-1

    private var lastselectedPosition:Int =-1

    override fun onCreateViewHolder(        parent: ViewGroup,        viewType: Int    ): ViewHolderClass {
        val binding = ViewholderFilterdashBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolderClass(binding)
    }
    override fun onBindViewHolder(        holder: ViewHolderClass,        position: Int    ) {

        val item = dataList[position]
        holder.binding.CategoryFilterTxt.text = item.title

        if (selectedPosition == position) {
            holder.binding.CategoryFilterTxt.setBackgroundResource(R.drawable.black_bg)
            holder.binding.CategoryFilterTxt.setTextColor(
                ContextCompat.getColor(holder.itemView.context, R.color.poison_green)
            )
        } else {
            holder.binding.CategoryFilterTxt.setBackgroundResource(R.drawable.aqua_bg)
            holder.binding.CategoryFilterTxt.setTextColor(
                ContextCompat.getColor(holder.itemView.context, R.color.black)
            )
        }

        holder.itemView.setOnClickListener {
            lastselectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(lastselectedPosition)
            notifyItemChanged(selectedPosition)
        }


    }

    override fun getItemCount(): Int {
       return dataList.size
    }

    class ViewHolderClass(val binding: ViewholderFilterdashBinding) :
        RecyclerView.ViewHolder(binding.root)


}