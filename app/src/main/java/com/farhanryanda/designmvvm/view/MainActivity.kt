package com.farhanryanda.designmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.farhanryanda.designmvvm.R
import com.farhanryanda.designmvvm.databinding.ActivityMainBinding
import com.farhanryanda.designmvvm.databinding.ItemCarBinding
import com.farhanryanda.designmvvm.viewmodel.ViewModelCar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this).get(ViewModelCar::class.java)
        viewModel.callApiCar()
        viewModel.getLiveDataCar().observe(this , {
            if (it != null) {
                binding.rvCar.layoutManager = LinearLayoutManager(this)
                binding.rvCar.adapter = CarAdapter(it)
            }
        })
    }
}