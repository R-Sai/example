package com.example.myapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.di.DIHelper
import com.example.myapplication.domain.usecase.GetFactsUseCase
import com.example.myapplication.presentation.mapper.FactsMapper
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import toothpick.Toothpick
import javax.inject.Inject

class FactsViewModel : ViewModel() {

    init {
        Toothpick.inject(this, DIHelper.getScope())
    }

    private val _catFactList = MutableLiveData<List<String>>()
    val catFactList: LiveData<List<String>> by this::_catFactList

    @Inject
    lateinit var getFactsUseCase: GetFactsUseCase

    @Inject
    lateinit var mapper: FactsMapper

    var fetchCatsJob: Job? = null

    fun fetchFacts() {
        fetchCatsJob = viewModelScope.launch {
            getFactsUseCase.execute().map { facts ->
                facts.body()?.let {
                    mapper.map(it)
                }
            }.collect { factList ->
                _catFactList.postValue(factList)
            }
        }
    }

    override fun onCleared() {
        fetchCatsJob?.cancel()
    }
}