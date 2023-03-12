package gromov.numberapitestcase.main_feature.domain.usecase

import gromov.numberapitestcase.core.extention.resultOf
import gromov.numberapitestcase.main_feature.domain.model.NumberFact
import gromov.numberapitestcase.main_feature.domain.repository.NumberFactRepository

fun interface GetRandomFactUseCase : suspend () -> Result<NumberFact>

suspend fun getRandomNumber(
    numberRepository: NumberFactRepository
): Result<NumberFact> = resultOf {
    numberRepository.getRandomNumber()
}