package com.example.ecommerceapk.Activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerceapk.Adapter.SearchDashAdapter
import com.example.ecommerceapk.Adapter.ViewPageAdapter
import com.example.ecommerceapk.Domain.SearchDashClass
import com.example.ecommerceapk.R
import com.example.ecommerceapk.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val handler = Handler(Looper.getMainLooper())
    private var currentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageList = listOf(
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3
        )

        val adapter = ViewPageAdapter(imageList)
        binding.viewPagerSlider.adapter = adapter

        autoSlideImages(imageList.size)
        SearchDashCompo()
    }

    private fun autoSlideImages(imageCount: Int) {
        val runnable = object : Runnable {
            override fun run() {
                if (currentPage == imageCount) {
                    currentPage = 0
                }
                binding.viewPagerSlider.setCurrentItem(currentPage++, true)
                handler.postDelayed(this, 3000)
            }
        }
        handler.postDelayed(runnable, 3000)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }

    public fun SearchDashCompo(){
            val dataList=listOf(
                SearchDashClass(R.drawable.product1,"Sepatu Superstar","Man shoes"),
                SearchDashClass(R.drawable.product2,"Sneakers UltraBoost","Running shoes"),
                SearchDashClass(R.drawable.product3,"RS-X3","Man shoes"),
                SearchDashClass(R.drawable.product4,"Chuck Taylor All Star","Unisex shoes"),
                SearchDashClass(R.drawable.product5,"Air Max 90","Man shoes")
            )
        var adapter = SearchDashAdapter(dataList)
        binding.SearchDashboardView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.SearchDashboardView.adapter = adapter
    }
}
