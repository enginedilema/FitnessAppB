package org.insbaixcamp.fitnessappb.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ExerciseApiClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://oss.exercisedb.dev/")
        .addConverterFactory(
            GsonConverterFactory.create()
        )
        .build()

    val service: ExerciseDbApi =
        retrofit.create(ExerciseDbApi::class.java)
}