package com.example.ecommerceapk.Activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.ecommerceapk.Adapter.ViewPageAdapter
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
}
