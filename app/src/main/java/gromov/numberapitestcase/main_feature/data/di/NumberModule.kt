package gromov.numberapitestcase.main_feature.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gromov.numberapitestcase.main_feature.data.remote.api.NumberFactApi
import gromov.numberapitestcase.main_feature.data.repository.NumberFactRepositoryImpl
import gromov.numberapitestcase.main_feature.domain.repository.NumberFactRepository
import gromov.numberapitestcase.main_feature.domain.usecase.*
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NumberModule.BindsModule::class])
@InstallIn(SingletonComponent::class)
object NumberModule {

    @Provides
    @Singleton
    fun provideNumberApi(
        retrofit: Retrofit
    ): NumberFactApi {
        return retrofit.create(NumberFactApi::class.java)
    }

    @Provides
    fun provideGetFactAboutNumberUseCase(
        numberFactRepository: NumberFactRepository
    ): GetFactAboutNumberUseCase {
        return GetFactAboutNumberUseCase {
            getNumber(numberFactRepository, it)
        }
    }

    @Provides
    fun provideGetRandomFactUseCase(
        numberFactRepository: NumberFactRepository
    ): GetRandomFactUseCase {
        return GetRandomFactUseCase {
            getRandomNumber(numberFactRepository)
        }
    }

    @Provides
    fun provideSavedFactsUseCase(
        numberFactRepository: NumberFactRepository
    ): SavedFactsUseCase {
        return SavedFactsUseCase {
            getNumberList(numberFactRepository)
        }
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {

        @Binds
        fun bindNumberRepository(
            numberFactRepositoryImpl: NumberFactRepositoryImpl
        ): NumberFactRepository
    }
}