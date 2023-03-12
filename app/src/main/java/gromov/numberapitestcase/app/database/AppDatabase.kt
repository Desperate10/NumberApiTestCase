package gromov.numberapitestcase.app.database

import androidx.room.Database
import androidx.room.RoomDatabase
import gromov.numberapitestcase.main_feature.data.local.dao.NumberDao
import gromov.numberapitestcase.main_feature.data.local.entity.NumberFactDbModel

@Database(entities = [NumberFactDbModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun numberDao(): NumberDao
}