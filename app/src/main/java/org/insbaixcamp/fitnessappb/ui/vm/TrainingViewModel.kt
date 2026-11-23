package org.insbaixcamp.fitnessappb.ui.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.insbaixcamp.fitnessappb.data.Exercise
import org.insbaixcamp.fitnessappb.data.ExerciseApiClient
import org.insbaixcamp.fitnessappb.data.ExerciseResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TrainingViewModel : ViewModel() {
    //El llistat de tots els exercicis agafats de la API
    var exercisesTmp by mutableStateOf<List<Exercise>>(
        emptyList()
    )
    //Llistat d'exercicis que es mostren
    var exercises by mutableStateOf<List<Exercise>>(
        emptyList()
    )
        private set

    var isLoading by mutableStateOf(false)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    var hasNextPage by mutableStateOf(false)
        private set

    private var nextCursor: String? = null
    private var currentCall: Call<ExerciseResponse>? = null

    init {
        loadExercises()
    }

    //filtrar exercicis
    fun findExercises(query: String) {
        val filteredExercises = exercisesTmp.filter { exercise ->
            exercise.name.contains(query, ignoreCase = true)
        }
        exercises = filteredExercises
    }

    // Demana la primera pàgina
    fun loadExercises() {
        nextCursor = null
        hasNextPage = false
        exercisesTmp = emptyList()
        requestExercises(null)
    }

    // Demana la pàgina següent
    fun loadMore() {
        if (isLoading || !hasNextPage) return

        val cursor = nextCursor ?: return
        requestExercises(cursor)
    }

    private fun requestExercises(cursor: String?) {

        if (isLoading) return

        isLoading = true
        error = null

        val call = ExerciseApiClient.service
            .getExercises(after = cursor)

        currentCall = call

        call.enqueue(object : Callback<ExerciseResponse> {

            override fun onResponse(
                call: Call<ExerciseResponse>,
                response: Response<ExerciseResponse>
            ) {
                if (call !== currentCall) return

                isLoading = false
                currentCall = null

                val body = response.body()

                if (response.isSuccessful &&
                    body?.success == true
                ) {

                    exercisesTmp = if (cursor == null) {
                        body.data
                    } else {
                        exercisesTmp + body.data
                    }

                    nextCursor = body.meta.nextCursor

                    hasNextPage =
                        body.meta.hasNextPage &&
                                nextCursor != null

                } else {
                    error = "Error HTTP: ${response.code()}"
                }
                exercises = exercisesTmp
            }

            override fun onFailure(
                call: Call<ExerciseResponse>,
                t: Throwable
            ) {
                if (call !== currentCall) return

                isLoading = false
                currentCall = null

                if (!call.isCanceled) {
                    error = "Error de connexió: ${t.message}"
                }
            }
        })
    }

    override fun onCleared() {
        currentCall?.cancel()
        currentCall = null
        super.onCleared()
    }
}