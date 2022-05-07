package com.example.myapplication.data.repository

import com.example.myapplication.data.net.Api
import com.example.myapplication.domain.repository.FactsRepository

class FactsRepositoryImpl : FactsRepository {
    override suspend fun getFacts() = Api.create().getFacts()
}