package com.example.assignment.di

import com.example.assignment.activity.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponents {

    fun inject(mainActivity: MainActivity)
}