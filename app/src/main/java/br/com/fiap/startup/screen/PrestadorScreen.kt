package br.com.fiap.startup.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PrestadorScreen() {
    Column {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(
                onClick = {/* VAI PARA LOGIN SCREEN */ },
                modifier = Modifier.padding(8.dp),
                shape = RectangleShape
            ) {
                Text(
                    text = "LOGIN",
                    modifier = Modifier.padding(8.dp)
                )
            }
            Button(
                onClick = {/* VAI PARA BUSCA SCREEN */ },
                modifier = Modifier.padding(8.dp),
                shape = RectangleShape
            ) {
                Text(
                    text = "BUSCA",
                    modifier = Modifier.padding(8.dp)
                )
            }
            Button(
                onClick = {/* VAI PARA CADASTRO SCREEN */ },
                modifier = Modifier.padding(8.dp),
                shape = RectangleShape
            ) {
                Text(
                    text = "CADASTRO",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(2f)
                ) {
                    Text(
                        text = "Nome do Prestador",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Categoria",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Serviços",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Endereço",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Email",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Telefone",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = ""
                    )
                }
            }
        }
    }
}