package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.model.Facts
import com.example.myapplication.domain.repository.FactsRepository
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import toothpick.InjectConstructor

@InjectConstructor
class GetFactsUseCase(val factsRepository: FactsRepository) : UseCase<Response<Facts>> {

    override fun execute() = flow {
        emit(factsRepository.getFacts())
    }
}