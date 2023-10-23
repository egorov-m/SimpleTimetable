package com.example.simpletimetable.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.example.simpletimetable.R
import com.example.simpletimetable.databinding.FragmentMainBinding
import com.example.simpletimetable.settings.SettingsFragment
import com.example.simpletimetable.today.TodayFragment
import com.example.simpletimetable.week.WeekFragment

class MainFragment :  Fragment() {
    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.bottomNavigation?.setOnItemSelectedListener {
            changeTab(it.itemId)
            true
        }

        changeTab(R.id.navigation_settings)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    private fun changeTab(@IdRes id: Int) {
        val navHostId = binding?.navHost?.id
        navHostId ?: return
        val transaction = childFragmentManager.beginTransaction()
        when (id) {
            R.id.navigation_settings ->
                transaction.replace(navHostId, SettingsFragment.newInstance())
            R.id.navigation_today ->
                transaction.replace(navHostId, TodayFragment.newInstance())
            R.id.navigation_week ->
                transaction.replace(navHostId, WeekFragment.newInstance())
        }
        transaction.commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MainFragment().apply {

            }
    }
}