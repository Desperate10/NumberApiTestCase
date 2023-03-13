package gromov.numberapitestcase.main_feature.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gromov.numberapitestcase.main_feature.data.mapper.toPresentationModel
import gromov.numberapitestcase.main_feature.domain.usecase.GetFactAboutNumberUseCase
import gromov.numberapitestcase.main_feature.domain.usecase.GetRandomFactUseCase
import gromov.numberapitestcase.main_feature.domain.usecase.SavedFactsUseCase
import gromov.numberapitestcase.main_feature.presentation.model.NumberFactView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val history: SavedFactsUseCase,
    private val number: GetFactAboutNumberUseCase,
    private val randomNumber: GetRandomFactUseCase
) : ViewModel() {

    private val _historyNumbers = MutableStateFlow(emptyList<NumberFactView>())
    val historyNumbers = _historyNumbers

    private val _errorMessage = MutableSharedFlow<String>(0)
    val errorMessage = _errorMessage

    init {
        getHistory()
    }

    private fun getHistory() {
        viewModelScope.launch(Dispatchers.IO) {
            history()
                .collect {
                    _historyNumbers.emit(it.map { number -> number.toPresentationModel() })
                }
        }
    }

    fun getNumber(number: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            number(number)
                .onFailure {
                    _errorMessage.emit(it.message ?: "Error")
                }
        }
    }

    fun getRandomNumber() {
        viewModelScope.launch(Dispatchers.IO) {
            randomNumber()
                .onFailure {
                    _errorMessage.emit(it.message ?: "Error")
                }
        }
    }
}