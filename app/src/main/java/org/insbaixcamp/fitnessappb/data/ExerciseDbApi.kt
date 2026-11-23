package org.insbaixcamp.fitnessappb.data


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ExerciseDbApi {

    @GET("api/v1/exercises")
    fun getExercises(
        @Query("after") after: String? = null
    ): Call<ExerciseResponse>

    @GET("api/v1/exercises/search")
    fun searchExercises(
        @Query("search") query: String
    ): Call<ExerciseResponse>
}

