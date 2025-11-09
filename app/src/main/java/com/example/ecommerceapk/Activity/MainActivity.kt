package com.example.ecommerceapk.Activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ecommerceapk.Adapter.DiscItemAdapter
import com.example.ecommerceapk.Adapter.FilterDashAdapter
import com.example.ecommerceapk.Adapter.SearchDashAdapter
import com.example.ecommerceapk.Adapter.ViewPageAdapter
import com.example.ecommerceapk.Domain.DiscItemClass
import com.example.ecommerceapk.Domain.FilterDashClass
import com.example.ecommerceapk.Domain.SearchDashClass
import com.example.ecommerceapk.R
import com.example.ecommerceapk.databinding.ActivityMainBinding
import android.content.res.ColorStateList
import android.os.Build
import android.view.View
import android.view.WindowInsetsController
import androidx.core.content.ContextCompat
import com.example.ecommerceapk.Utils.BottomNavHelper


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val handler = Handler(Looper.getMainLooper())
    private var currentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.setSystemBarsAppearance(
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
            )
            window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        }

        bannerImgCompo()
        SearchDashCompo()
        FilterDashCompo()
        DisItemCompo()

        BottomNavHelper.setupBottomNav(this, binding.bottomNavigationView, R.id.home)

    }
    private fun bannerImgCompo() {

            val imageList = listOf(
                R.drawable.banner1,
                R.drawable.banner2,
                R.drawable.banner3
            )

            val adapter = ViewPageAdapter(imageList)
            binding.viewPagerSlider.adapter = adapter

            autoSlideImages(imageList.size)
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

    private fun SearchDashCompo(){
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

    private fun FilterDashCompo()    {
        val dataList=listOf(
            FilterDashClass("Last Chance Picks"),
            FilterDashClass("Today’s Pick"),
            FilterDashClass("Recently Viewed"),
            FilterDashClass("Last Chance Picks"),
            FilterDashClass("SPORT")
        )
        var adapter = FilterDashAdapter(dataList)
        binding.FilterDashView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.FilterDashView.adapter = adapter

    }

    private fun DisItemCompo(){

        val dataList=listOf(
            DiscItemClass(R.drawable.product1,R.drawable.comp_icon,"Sepatu Superstar","Man shoes","DISC. 30%","Rs1500","Rs1200"),
            DiscItemClass(R.drawable.product2,R.drawable.comp2_icon,"Sneakers UltraBoost","Running shoes","DISC. 30%","Rs1500","Rs1200"),
            DiscItemClass(R.drawable.product3,R.drawable.comp3_icon,"RS-X3","Man shoes","DISC. 30%","Rs1500","Rs1200"),
            DiscItemClass(R.drawable.product4,R.drawable.comp4_icon,"Chuck Taylor All Star","Unisex shoes","DISC. 30%","Rs1500","Rs1200"),
            DiscItemClass(R.drawable.product5,R.drawable.comp_icon,"Air Max 90","Man shoes","DISC. 30%","Rs1500","Rs1200"),
            DiscItemClass(R.drawable.product3,R.drawable.comp3_icon,"RS-X3","Man shoes","DISC. 30%","Rs1500","Rs1200"))

        var adapter = DiscItemAdapter(dataList)
        binding.DiscDashboardView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.DiscDashboardView.adapter = adapter
    }


}

