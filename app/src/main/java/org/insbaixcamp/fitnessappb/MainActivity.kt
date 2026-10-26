package org.insbaixcamp.fitnessappb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.insbaixcamp.fitnessappb.ui.screen.EditProfileScreen
import org.insbaixcamp.fitnessappb.ui.screen.ProfileScreen
import org.insbaixcamp.fitnessappb.ui.theme.FitnessAppBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitnessAppBTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        FitnessApp()
                    }
                }
            }
        }
    }
}


@Composable
fun FitnessApp() {
    var nom: String by remember { mutableStateOf("Laia Soler") }
    var email: String by remember { mutableStateOf("laia.soler@example.com") }
    //data naixement
    var dataNaixement: Long by remember { mutableStateOf( 946684800000) }
    var genere: String by remember { mutableStateOf("Dona") }
    var editant:Boolean by remember { mutableStateOf(true) }
    var pes: Double by remember { mutableStateOf(60.0) }
    var pesObjectiu: Double by remember { mutableStateOf(55.0) }
    var alçada:Int by remember { mutableStateOf(170) }
    var objectiu:String by remember { mutableStateOf("Guanyar massa muscular") }

    if(editant){
        EditProfileScreen(
            nom, email, dataNaixement, genere, pes, pesObjectiu, alçada, objectiu,
            onSave = { nomN, emailN, dataNaixementN, genereN,
                       pesN, pesObjectiuN, alçadaN ->
                nom = nomN
                email = emailN
                dataNaixement = dataNaixementN
                genere = genereN
                pes = pesN
                pesObjectiu = pesObjectiuN
                alçada = alçadaN
                editant = false
            }
        )
    }else{
        ProfileScreen(nom, email, dataNaixement, genere, pes, alçada, objectiu, onEditar = {editant=true})
    }


}
@Preview(showBackground = true)
@Composable
fun FitnessAppPreview() {
    FitnessAppBTheme {
        FitnessApp()
    }
}