package gromov.numberapitestcase.main_feature.data.mapper

import gromov.numberapitestcase.main_feature.data.local.entity.NumberFactDbModel
import gromov.numberapitestcase.main_feature.data.remote.model.NumberFactResponse
import gromov.numberapitestcase.main_feature.domain.model.NumberFact
import gromov.numberapitestcase.main_feature.presentation.model.NumberFactView

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

fun NumberFact.toPresentationModel() = NumberFactView(
    number = number,
    text = text.split(" ", limit = 2)[1]
)