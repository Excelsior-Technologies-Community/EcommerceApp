package com.example.ecommerceapk.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ecommerceapk.Adapter.SearDicAdapter
import com.example.ecommerceapk.Domain.DiscItemClass
import com.example.ecommerceapk.R
import com.example.ecommerceapk.Utils.BottomNavHelper
import com.example.ecommerceapk.databinding.ActivitySearchBinding


class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)


        BottomNavHelper.setupBottomNav(this, binding.bottomNavigationView, R.id.search)
        sDisItemCompo()
    }

    private fun sDisItemCompo() {
        val dataList = listOf(
            DiscItemClass(R.drawable.product1, R.drawable.comp_icon, "Sepatu Superstar", "Man shoes", "DISC. 30%", "Rp510.00", "Rp510.00"),
            DiscItemClass(R.drawable.product2, R.drawable.comp2_icon, "Sneakers UltraBoost", "Running shoes", "DISC. 30%", "Rp510.00", "Rp510.00"),
            DiscItemClass(R.drawable.product3, R.drawable.comp3_icon, "RS-X3", "Man shoes", "DISC. 30%", "Rp510.00", "Rp510.00"),
            DiscItemClass(R.drawable.product4, R.drawable.comp4_icon, "Chuck Taylor All Star", "Unisex shoes", "DISC. 30%", "Rp510.00", "Rp510.00"),
            DiscItemClass(R.drawable.product5, R.drawable.comp_icon, "Air Max 90", "Man shoes", "DISC. 30%", "Rp510.00", "Rp510.00"),
            DiscItemClass(R.drawable.product3, R.drawable.comp3_icon, "RS-X3", "Man shoes", "DISC. 30%", "Rp510.00", "Rp510.00")
        )

        val adapter = SearDicAdapter(dataList)

        binding.discSearchView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.discSearchView.isNestedScrollingEnabled = false
        binding.discSearchView.adapter = adapter
    }
}