package com.example.ecommerceapk.Activity

import android.os.Build
import android.os.Bundle
import android.view.WindowInsetsController
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerceapk.Adapter.BagItemAdapter
import com.example.ecommerceapk.Adapter.FilterDashAdapter
import com.example.ecommerceapk.Domain.BagItemClass
import com.example.ecommerceapk.Domain.DiscItemClass
import com.example.ecommerceapk.R
import com.example.ecommerceapk.Utils.BottomNavHelper
import com.example.ecommerceapk.databinding.ActivityBagBinding


class BagActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBagBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBagBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.setSystemBarsAppearance(
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
            )
            window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        }

        BottomNavHelper.setupBottomNav(this, binding.bottomNavigationView, R.id.bag)

        BagItemComp()

    }
    private fun BagItemComp(){

        val dataList=listOf(
            BagItemClass(R.drawable.product1, "Sepatu Superstar","Man shoes",  "Rs1500", "Rs1200"),
            BagItemClass(R.drawable.product2,"Sneakers UltraBoost","Running shoes","Rs1500","Rs1200"),
            BagItemClass(R.drawable.product3,"RS-X3","Man shoes","Rs1500","Rs1200"),
            BagItemClass(R.drawable.product4,"Chuck Taylor All Star","Unisex shoes","Rs1500","Rs1200"),
            BagItemClass(R.drawable.product5,"Air Max 90","Man shoes","Rs1500","Rs1200"),
            BagItemClass(R.drawable.product3,"RS-X3","Man shoes","Rs1500","Rs1200"))


        var adapter = BagItemAdapter(dataList)
        binding.bagCashoutView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.bagCashoutView.adapter = adapter
    }
}