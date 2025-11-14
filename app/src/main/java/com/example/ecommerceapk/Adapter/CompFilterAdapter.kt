package com.example.ecommerceapk.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapk.Adapter.FilterDashAdapter.ViewHolderClass
import com.example.ecommerceapk.Domain.FilterDashClass
import com.example.ecommerceapk.R
import com.example.ecommerceapk.databinding.ViewholderCompfilterBinding
import com.example.ecommerceapk.databinding.ViewholderFilterdashBinding

class CompFilterAdapter (  private val dataList: List<FilterDashClass>
) : RecyclerView.Adapter<CompFilterAdapter.ViewHolderClass>() {
    private var selectedPosition:Int =0

    private var lastselectedPosition:Int =-1

    override fun onCreateViewHolder(        parent: ViewGroup,        viewType: Int    ): CompFilterAdapter.ViewHolderClass {
        val binding = ViewholderCompfilterBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolderClass(binding)
    }

    override fun onBindViewHolder(holder: CompFilterAdapter.ViewHolderClass, position: Int) {
        val item = dataList[position]
        holder.binding.CategoryComFilterTxt.text = item.title

        if (selectedPosition == position) {
            holder.binding.CategoryComFilterTxt.setBackgroundResource(R.drawable.full_circle)
            holder.binding.CategoryComFilterTxt.setTextColor(
                ContextCompat.getColor(holder.itemView.context, R.color.poison_green)
            )
        } else {
            holder.binding.CategoryComFilterTxt.setBackgroundResource(R.drawable.full_circle_aqua)
            holder.binding.CategoryComFilterTxt.setTextColor(
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

    class ViewHolderClass(val binding: ViewholderCompfilterBinding) :
        RecyclerView.ViewHolder(binding.root)

}