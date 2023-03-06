package com.example.assignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment.model.ColorModel
import com.example.assignment.repository.ColorRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ColorRepository) : ViewModel() {

    val colorLiveData: LiveData<List<ColorModel>>
        get() = repository.colorList

    init {
        getAllMovies()
    }

    fun getAllMovies()
    {
        viewModelScope.launch {
            repository.getMovie()
        }
    }
}


