package com.example.assignment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignment.repository.ColorRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val repository: ColorRepository):ViewModelProvider.Factory  {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}