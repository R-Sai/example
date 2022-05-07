package com.example.myapplication.domain.usecase

import kotlinx.coroutines.flow.Flow

interface UseCase<T> {
    fun execute(): Flow<T>
}