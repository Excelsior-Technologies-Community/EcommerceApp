package com.example.ecommerceapk.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapk.Domain.BagItemClass
import com.example.ecommerceapk.databinding.ViewholderCashoutBinding


class BagItemAdapter (private val dataList: List<BagItemClass>):
    RecyclerView.Adapter<BagItemAdapter.ViewHolderClass>()  {

    class ViewHolderClass(val binding: ViewholderCashoutBinding) :

        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(       parent: ViewGroup,        viewType: Int): BagItemAdapter.ViewHolderClass {
     val binding = ViewholderCashoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderClass(binding)
     }

    override fun onBindViewHolder(holder: BagItemAdapter.ViewHolderClass, position: Int) {
        val item = dataList[position]
        holder.binding.picBag.setBackgroundResource(item.picBag)
        holder.binding.titlebagTxt.text = item.titleBag
        holder.binding.CategorybagTxt.text=item.categBag
        holder.binding.oldpriceBagTxt.text=item.oldPriceBag
        holder.binding.pricebagTxt.text =item.priceBag
        holder.binding.oldpriceBagTxt.paintFlags = holder.binding.oldpriceBagTxt.paintFlags
    }

    override fun getItemCount(): Int {

        return dataList.size

    }

}