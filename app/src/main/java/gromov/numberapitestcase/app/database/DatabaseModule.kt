package gromov.numberapitestcase.app.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import gromov.numberapitestcase.main_feature.data.local.dao.NumberDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "numbers_db"
        ).build()
    }

    @Provides
    fun provideNumberDao(appDatabase: AppDatabase) : NumberDao {
        return appDatabase.numberDao()
    }
}