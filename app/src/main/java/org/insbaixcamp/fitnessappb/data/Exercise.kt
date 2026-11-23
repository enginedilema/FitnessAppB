package org.insbaixcamp.fitnessappb.data

data class Exercise(
    val exerciseId: String,
    val name: String,
    val gifUrl: String,
    val bodyParts: List<String>,
    val equipments: List<String>,
    val targetMuscles: List<String>,
    val instructions: List<String>
)
//Per la paginació
data class ExerciseMeta(
    val total: Int,
    val hasNextPage: Boolean,
    val nextCursor: String?
)
//El que realment retorna la API
data class ExerciseResponse(
    val success: Boolean,
    val meta: ExerciseMeta,
    val data: List<Exercise>
)