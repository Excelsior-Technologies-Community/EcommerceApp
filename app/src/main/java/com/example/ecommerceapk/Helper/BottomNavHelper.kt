package com.example.ecommerceapk.Utils

import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import com.example.ecommerceapk.Activity.MainActivity
import com.example.ecommerceapk.Activity.SearchActivity
import com.example.ecommerceapk.R
import com.google.android.material.bottomnavigation.BottomNavigationView

object BottomNavHelper {

    fun setupBottomNav(activity: Activity, bottomNavigationView: BottomNavigationView, selectedItemId: Int) {

        setBottomNavColors(activity, bottomNavigationView)


        bottomNavigationView.selectedItemId = selectedItemId


        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    if (activity !is MainActivity) {
                        activity.startActivity(Intent(activity, MainActivity::class.java))
                        activity.overridePendingTransition(0, 0)
                        activity.finish()
                    }
                    true
                }

                R.id.search -> {
                    if (activity !is SearchActivity) {
                        activity.startActivity(Intent(activity, SearchActivity::class.java))
                        activity.overridePendingTransition(0, 0)
                        activity.finish()
                    }
                    true
                }

                else -> false
            }
        }
    }

    private fun setBottomNavColors(activity: Activity, bottomNavigationView: BottomNavigationView) {
        val states = arrayOf(
            intArrayOf(android.R.attr.state_checked),
            intArrayOf(-android.R.attr.state_checked)
        )

        val colors = intArrayOf(
            ContextCompat.getColor(activity, R.color.black),
            ContextCompat.getColor(activity, R.color.icon_color)
        )

        val colorStateList = ColorStateList(states, colors)

        bottomNavigationView.itemIconTintList = colorStateList
        bottomNavigationView.itemTextColor = colorStateList
    }
}
