package gromov.numberapitestcase.main_feature.domain.usecase

import gromov.numberapitestcase.main_feature.domain.model.NumberFact
import gromov.numberapitestcase.main_feature.domain.repository.NumberFactRepository
import kotlinx.coroutines.flow.Flow

fun interface SavedFactsUseCase : suspend () -> Flow<List<NumberFact>>

fun getNumberList(
    numberRepository: NumberFactRepository
): Flow<List<NumberFact>> =
    numberRepository.getNumberList()