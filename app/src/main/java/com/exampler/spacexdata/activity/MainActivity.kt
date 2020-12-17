package com.exampler.spacexdata.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.exampler.spacexdata.R
import com.exampler.spacexdata.databinding.ActivityMainBinding
import com.exampler.spacexdata.fragments.ListFragment

const val TAG = "Mylogs"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        if (savedInstanceState == null) {
            val fragment = ListFragment()
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, fragment)
            fragmentTransaction.commit()
        }

    }
}