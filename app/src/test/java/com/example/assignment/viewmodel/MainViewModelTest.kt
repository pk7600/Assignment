package com.example.assignment.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.assignment.MainCoroutinesRule
import com.example.assignment.model.ColorModel
import com.example.assignment.repository.ColorRepository
import com.raminabbasiiii.movies.getOrAwaitValueTest
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
internal class MainViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutinesRule = MainCoroutinesRule()

    private lateinit var viewModel: MainViewModel


    val colorLiveData: LiveData<List<ColorModel>>
        get() = repository.colorList


    @Mock
    lateinit var repository: ColorRepository

    @Mock
    lateinit var colorDetailsResponseObserver: Observer<List<ColorModel>>

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        viewModel = MainViewModel(repository)
    }



    @Test
    fun `when return a color list successfully`() {
        runTest {
        
            viewModel.colorLiveData.observeForever(colorDetailsResponseObserver)
            BDDMockito.given(repository.getMovie())
            BDDMockito.verify(repository).getMovie()
            viewModel.getAllMovies()
            Assert.assertNotNull(viewModel.colorLiveData.value)
            assertEquals(colorLiveData.value,viewModel.colorLiveData.getOrAwaitValueTest())
        }
    }


}