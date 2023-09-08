package br.com.fiap.startup.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.SpaceEvenly
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.startup.database.repository.PrestadorRepository
import androidx.navigation.compose.rememberNavController
import br.com.fiap.startup.model.Prestador


//Busca prestador por categoria
@Composable
fun BuscaScreen(navController: NavController) {

    val context = LocalContext.current
    val prestadorRepository = PrestadorRepository(context)

    var categoria = remember {
        mutableStateOf("")
    }
    var contatoListState = remember {
        mutableStateOf(prestadorRepository.listarPrestadoresPelaCategoria(categoria.value))
    }

    Column {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(
                onClick = { navController.navigate("login") },
                modifier = Modifier.padding(8.dp),
                shape = RectangleShape
            ) {
                Text(
                    text = "SAIR",
                    modifier = Modifier.padding(8.dp)
                )
            }
            Button(
                onClick = { navController.navigate("cadastro") },
                modifier = Modifier.padding(8.dp),
                shape = RectangleShape
            ) {
                Text(
                    text = "CADASTRO",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        BuscaForm(
            categoria = categoria.value,
            onCategoriaChange = {
                categoria.value = it
            }, atualizar = {
                contatoListState.value = prestadorRepository.listarPrestadoresPelaCategoria(categoria.value)
            }
        )
        BuscaList(navController = navController, contatoListState.value)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuscaForm(
    categoria: String,
    onCategoriaChange: (String) -> Unit,
    atualizar: () -> Unit
) {
    //Obter contexto
    val context = LocalContext.current
    val prestadorRepository = PrestadorRepository(context)

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Busque seu Serviço",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(
                0xFFE91E63
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = categoria,
            onValueChange = { onCategoriaChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Categoria do Serviço")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                prestadorRepository.listarPrestadoresPelaCategoria(categoria)
                atualizar()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "BUSCAR",
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun BuscaList(navController: NavController, prestadores : List<Prestador>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        for (prestador in prestadores) {
            BuscaCard(navController = navController , prestador)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
fun BuscaCard(navController: NavController, prestador : Prestador) {
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
                    text = prestador.endereco,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            IconButton(onClick = {
                val id : String = prestador.id.toString()
                navController.navigate("prestador/" + id) }) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = ""
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BuscaScreenPreview() {
    val navController = rememberNavController()
    BuscaScreen(navController = navController)
}