package com.example.myapplication.presentation.mapper

import com.example.myapplication.domain.model.Facts
import javax.inject.Singleton

@Singleton
class FactsMapper {
    fun map(facts: Facts): List<String> = facts.data.map { it.fact }
}