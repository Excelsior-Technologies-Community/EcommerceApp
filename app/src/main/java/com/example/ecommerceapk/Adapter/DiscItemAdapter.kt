package com.example.ecommerceapk.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapk.Domain.DiscItemClass
import com.example.ecommerceapk.databinding.ViewholderDisitemBinding
import com.example.ecommerceapk.databinding.ViewholderSerachdashbordBinding

class DiscItemAdapter (private val dataList: List<DiscItemClass>):
    RecyclerView.Adapter<DiscItemAdapter.ViewHolderClass>(){
    class ViewHolderClass(val binding: ViewholderDisitemBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int  ): ViewHolderClass {
        val binding = ViewholderDisitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderClass(binding)

    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int  ) {
        val item = dataList[position]
        holder.binding.picDis.setBackgroundResource(item.picdis)
        holder.binding.companyIcon.setBackgroundResource(item.compicon)
        holder.binding.titleDiscTxt.text = item.titledis
        holder.binding.CategoryDisTxt.text=item.categorydis
        holder.binding.offPercentTxt.text=item.offperc
        holder.binding.oldpriceoffTxt.text=item.oldpricedic
        holder.binding.priceDisTxt.text =item.pricedis

    }

    override fun getItemCount(): Int {
        return dataList.size
    }


}


