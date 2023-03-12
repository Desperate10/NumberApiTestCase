package gromov.numberapitestcase.main_feature.data.remote.api

import gromov.numberapitestcase.main_feature.data.remote.model.NumberFactResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface NumberFactApi {

    @GET("{number}?json")
    suspend fun getNumberFact(@Path("number") number: Int): NumberFactResponse

    @GET("random/math?json")
    suspend fun getRandomNumberFact(): NumberFactResponse
}