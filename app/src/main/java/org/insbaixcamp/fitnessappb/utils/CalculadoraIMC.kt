package org.insbaixcamp.fitnessappb.utils

import kotlin.math.round

class CalculadoraIMC {
    companion object {
        fun calcularIMC(pes: Double, alçada: Int): Double {
            val alturaMetros = alçada.toDouble() / 100
            val imc = pes / (alturaMetros * alturaMetros)
            return round(imc * 100) / 100
        }

    }
}