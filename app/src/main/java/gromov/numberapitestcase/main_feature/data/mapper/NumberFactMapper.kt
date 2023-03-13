package gromov.numberapitestcase.main_feature.data.mapper

import gromov.numberapitestcase.main_feature.data.local.entity.NumberFactDbModel
import gromov.numberapitestcase.main_feature.data.remote.model.NumberFactResponse
import gromov.numberapitestcase.main_feature.domain.model.NumberFact

fun NumberFactResponse.toDomainModel() = NumberFact(
    number = number,
    text = text
)

fun NumberFactDbModel.toDomainModel() = NumberFact(
    number = number,
    text = text
)

fun NumberFact.toEntityModel() = NumberFactDbModel(
    number = number,
    text = text
)