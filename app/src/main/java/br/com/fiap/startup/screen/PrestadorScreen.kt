package br.com.fiap.startup.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.startup.database.repository.PrestadorRepository
import br.com.fiap.startup.model.Prestador

@Composable
fun PrestadorScreen(navController: NavController, id : String) {
    val context = LocalContext.current
    val prestadorRepository = PrestadorRepository(context)
    val prestador = prestadorRepository.buscarPrestadorPeloId(id.toLong())
    Column {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(
                onClick = { navController.navigate("login") },
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(Color.Black),
                shape = CircleShape
            ) {
                Text(
                    text = "LOGIN",
                    modifier = Modifier.padding(8.dp)
                )
            }
            Button(
                onClick = { navController.navigate("busca") },
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(Color.Black),
                shape = CircleShape
            ) {
                Text(
                    text = "BUSCA",
                    modifier = Modifier.padding(8.dp)
                )
            }
            Button(
                onClick = { navController.navigate("cadastro") },
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFFF4500)),
                shape = CircleShape
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
                        text = prestador.nome,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = prestador.categoria,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = prestador.servicos,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = prestador.endereco,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = prestador.email,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = prestador.telefone,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PrestadorScreenPreview(){
    val navController = rememberNavController()
    val id : Long = 0
    PrestadorScreen(navController = navController, id.toString())
}