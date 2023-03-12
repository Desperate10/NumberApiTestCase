package gromov.numberapitestcase.main_feature.domain.repository

import gromov.numberapitestcase.main_feature.domain.model.NumberFact
import kotlinx.coroutines.flow.Flow

interface NumberFactRepository {

    fun getNumberList(): Flow<List<NumberFact>>

    suspend fun getNumber(number: Int): NumberFact

    suspend fun getRandomNumber(): NumberFact
}