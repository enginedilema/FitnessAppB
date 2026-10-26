package org.insbaixcamp.fitnessappb.ui.screen

import android.R.attr.onClick
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.insbaixcamp.fitnessappb.R
import org.insbaixcamp.fitnessappb.ui.component.formatDate
import java.util.Calendar

@Composable
fun ProfileScreen(
    nom:String,
    email:String,
    dataNaixement:Long,
    genere:String,
    pes: Double,
    alçada:Int,
    objectiu:String,
    onEditar:()->Unit
){
    Column() {
        //caixa de foto i nom
        Column(Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.Black)
            )
            Text(
                nom,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Text(email,
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center)
        }
        Spacer(Modifier.padding(16.dp))
        Card(Modifier.padding(horizontal = 16.dp)){
            Row(){
                //Caixa data de naixement
                Column(Modifier.padding(16.dp)){
                    Text("Edat", fontSize = 16.sp, color = Color.Gray)
                    val formattedDate = dataNaixement?.let { formatDate(it) } ?: ""
                    Text(formattedDate, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
                //Caixa genere
                Column(Modifier.padding(16.dp)){
                    Text("Genere", fontSize = 16.sp, color = Color.Gray)
                    Text(genere, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
                //Caixa alçada
                Column(Modifier.padding(16.dp)){
                    Text("Alçada", fontSize = 16.sp, color = Color.Gray)
                    Text("$alçada cm", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
                //Caixa pes
                Column(Modifier.padding(16.dp)){
                    Text("Pes", fontSize = 16.sp, color = Color.Gray)
                    Text("$pes Kg", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
        Spacer(Modifier.padding(16.dp))
        Text("Objectiu", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 16.dp))
        Card(Modifier.padding(horizontal = 16.dp)){
            Text(objectiu, 
                fontSize = 16.sp, 
                color = Color.Gray, 
                modifier = Modifier.padding(16.dp))
        }
        
    }
    Column(Modifier.fillMaxWidth(),horizontalAlignment = Alignment.End){
        Image(
            painter = painterResource(android.R.drawable.ic_menu_edit),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .clickable(onClick = onEditar)


        )
    }
}