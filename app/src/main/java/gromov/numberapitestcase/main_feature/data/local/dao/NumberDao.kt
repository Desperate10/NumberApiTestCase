package gromov.numberapitestcase.main_feature.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import gromov.numberapitestcase.main_feature.data.local.entity.NumberFactDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NumberDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNumber(number: NumberFactDbModel)

    @Query("SELECT * FROM numbers")
    fun getAllNumbers(): Flow<List<NumberFactDbModel>>

    @Query("SELECT * FROM numbers WHERE number = :number")
    suspend fun getNumber(number: Int): NumberFactDbModel?
}