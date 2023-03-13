package gromov.numberapitestcase.main_feature.data.repository

import gromov.numberapitestcase.main_feature.data.local.dao.NumberDao
import gromov.numberapitestcase.main_feature.data.mapper.toDomainModel
import gromov.numberapitestcase.main_feature.data.mapper.toEntityModel
import gromov.numberapitestcase.main_feature.data.remote.api.NumberFactApi
import gromov.numberapitestcase.main_feature.domain.model.NumberFact
import gromov.numberapitestcase.main_feature.domain.repository.NumberFactRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NumberFactRepositoryImpl @Inject constructor(
    private val numberApi: NumberFactApi,
    private val numberDao: NumberDao
) : NumberFactRepository {

    override fun getNumberList(): Flow<List<NumberFact>> {
        return numberDao.getAllNumbers()
            .map { list ->
                list.map { it.toDomainModel() }
            }
    }

    override suspend fun getNumber(number: Int): NumberFact {
        return numberDao.getNumber(number)
            ?.toDomainModel()
            ?: return numberApi.getNumberFact(number)
                .toDomainModel()
                .also {
                    numberDao.insertNumber(it.toEntityModel())
                }
    }

    override suspend fun getRandomNumber(): NumberFact {
        return numberApi.getRandomNumberFact()
            .toDomainModel()
            .also {
                numberDao.insertNumber(it.toEntityModel())
            }
    }
}