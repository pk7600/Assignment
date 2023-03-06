package com.example.assignment.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.assignment.AssignmentApplication
import com.example.assignment.R
import com.example.assignment.adapter.ColorAdapter
import com.example.assignment.databinding.ActivityMainBinding
import com.example.assignment.model.ColorModel
import com.example.assignment.viewmodel.MainViewModel
import com.example.assignment.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    lateinit var mainViewModel: MainViewModel
    lateinit var binding: ActivityMainBinding
    lateinit var movieAdapter: ColorAdapter

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        (application as AssignmentApplication).applicationComponent.inject(this)

        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

        movieAdapter = ColorAdapter()

        binding.rvColor.apply {
            adapter = movieAdapter
            setHasFixedSize(true)
        }

        mainViewModel.colorLiveData.observe(this) { list ->

            Log.e("TAG", "onCreate: size==> ${list.size}")

            movieAdapter.setData(list as ArrayList<ColorModel>)
        }

    }
}