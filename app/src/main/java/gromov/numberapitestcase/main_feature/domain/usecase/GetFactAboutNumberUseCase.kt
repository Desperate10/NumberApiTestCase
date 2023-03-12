package gromov.numberapitestcase.main_feature.domain.usecase

import gromov.numberapitestcase.core.extention.resultOf
import gromov.numberapitestcase.main_feature.domain.model.NumberFact
import gromov.numberapitestcase.main_feature.domain.repository.NumberFactRepository

fun interface GetFactAboutNumberUseCase : suspend (Int) -> Result<NumberFact>

suspend fun getNumber(
    numberFactRepository: NumberFactRepository,
    number: Int
): Result<NumberFact> = resultOf {
    numberFactRepository.getNumber(
        number as? Int ?: throw IllegalArgumentException("Number must be Int")
    )
}