package com.example.myapplication.di

import android.app.Application
import android.content.Context
import com.example.myapplication.data.repository.FactsRepositoryImpl
import com.example.myapplication.domain.repository.FactsRepository
import toothpick.config.Module

class AppModule() : Module() {

    init {
        bind(FactsRepository::class.java).toInstance(FactsRepositoryImpl())
    }
}