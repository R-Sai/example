package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.Facts
import retrofit2.Response

interface FactsRepository {
    suspend fun getFacts(): Response<Facts>
}