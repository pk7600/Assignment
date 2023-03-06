package com.example.assignment.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.assignment.model.ColorModel
import com.example.assignment.retrofit.ColorInterface
import javax.inject.Inject

class ColorRepository @Inject constructor(private val colorApi : ColorInterface) {


    private val _colorList = MutableLiveData<List<ColorModel>>()
    val colorList: LiveData<List<ColorModel>>
    get() = _colorList

    suspend fun getMovie()
    {
        val result = colorApi.getColor()
        if(result.isSuccessful && result.body() != null)
        {
            _colorList.postValue(result.body())
        }
    }
}