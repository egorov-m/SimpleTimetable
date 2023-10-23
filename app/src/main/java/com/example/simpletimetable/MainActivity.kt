package com.example.simpletimetable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simpletimetable.databinding.ActivityMainBinding
import com.example.simpletimetable.main.MainFragment

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentRootLayout.id, MainFragment.newInstance())
            .commit()
    }
}