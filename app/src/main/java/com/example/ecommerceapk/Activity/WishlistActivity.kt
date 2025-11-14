package com.example.ecommerceapk.Activity

import android.os.Build
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.WindowInsetsController
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ecommerceapk.Adapter.CompFilterAdapter
import com.example.ecommerceapk.Adapter.DiscItemAdapter
import com.example.ecommerceapk.Adapter.FilterDashAdapter
import com.example.ecommerceapk.Adapter.WishlistItemsAdapter
import com.example.ecommerceapk.Domain.DiscItemClass
import com.example.ecommerceapk.Domain.FilterDashClass
import com.example.ecommerceapk.R
import com.example.ecommerceapk.Utils.BottomNavHelper
import com.example.ecommerceapk.databinding.ActivityMainBinding
import com.example.ecommerceapk.databinding.ActivityWishlistBinding

private lateinit var binding: ActivityWishlistBinding
class WishlistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityWishlistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.setSystemBarsAppearance(
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
            )
            window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        }

        CompFilterCompo()
        WishlistItems()

        binding.CategoryFilterTxt.movementMethod = ScrollingMovementMethod()
        BottomNavHelper.setupBottomNav(this, binding.bottomNavigationView, R.id.wishlist)

    }
    private fun CompFilterCompo()    {
        val dataList=listOf(
            FilterDashClass("All"),
            FilterDashClass("PUMA"),
            FilterDashClass("adidas"),
            FilterDashClass("converse"),
            FilterDashClass("Nike")
        )
        var adapter = CompFilterAdapter(dataList)
        binding.CompFilterView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.CompFilterView.adapter = adapter

    }

    private fun WishlistItems(){

        val dataList=listOf(
            DiscItemClass(R.drawable.product1,R.drawable.comp_icon,"Sepatu Superstar","Man shoes","DISC. 30%","Rs1500","Rs1200"),
            DiscItemClass(R.drawable.product2,R.drawable.comp2_icon,"Sneakers UltraBoost","Running shoes","DISC. 30%","Rs1500","Rs1200"),
            DiscItemClass(R.drawable.product3,R.drawable.comp3_icon,"RS-X3","Man shoes","DISC. 30%","Rs1500","Rs1200"),
            DiscItemClass(R.drawable.product4,R.drawable.comp4_icon,"Chuck Taylor All Star","Unisex shoes","DISC. 30%","Rs1500","Rs1200"),
            DiscItemClass(R.drawable.product5,R.drawable.comp_icon,"Air Max 90","Man shoes","DISC. 30%","Rs1500","Rs1200"),
            DiscItemClass(R.drawable.product3,R.drawable.comp3_icon,"RS-X3","Man shoes","DISC. 30%","Rs1500","Rs1200"))

        var adapter = WishlistItemsAdapter(dataList)
        binding.WishlistItemsView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.WishlistItemsView.adapter = adapter
    }
}