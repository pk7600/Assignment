package com.example.assignment

import android.app.Application
import com.example.assignment.di.ApplicationComponents
import com.example.assignment.di.DaggerApplicationComponents

class AssignmentApplication : Application() {

    lateinit var applicationComponent: ApplicationComponents
    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponents.builder().build()

    }
}