package br.com.fiap.startup.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
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
import br.com.fiap.startup.database.repository.PrestadorRepository
import br.com.fiap.startup.model.Prestador
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


//Cadastrar Prestador
@Composable
fun CadastroScreen(navController: NavController) {

    val context = LocalContext.current
    val prestadorRepository = PrestadorRepository(context)

    var nomeState = remember {
        mutableStateOf("")
    }

    var categoriaState = remember {
        mutableStateOf("")
    }

    var servicosState = remember {
        mutableStateOf("")
    }

    var enderecoState = remember {
        mutableStateOf("")
    }

    var telefoneState = remember {
        mutableStateOf("")
    }

    var emailState = remember {
        mutableStateOf("")
    }

    var contatoListState = remember {
        mutableStateOf(prestadorRepository.listarPrestadores())
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
                onClick = { navController.navigate("busca") },
                modifier = Modifier.padding(8.dp),
                shape = RectangleShape
            ) {
                Text(
                    text = "BUSCA",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        CadastroForm(
            nome = nomeState.value,
            categoria = categoriaState.value,
            servicos = servicosState.value,
            endereco = enderecoState.value,
            telefone = telefoneState.value,
            email = emailState.value,
            atualizar = {
                contatoListState.value = prestadorRepository.listarPrestadores()
            },
            onNomeChange = {
                nomeState.value = it
            },
            onCategoriaChange = {
                categoriaState.value = it
            },
            onServicosChange = {
                servicosState.value = it
            },
            onEnderecoChange = {
                enderecoState.value = it
            },
            onTelefoneChange = {
                telefoneState.value = it
            },
            onEmailChange = {
                emailState.value = it
            }
        )
        CadastroList(contatoListState.value) {
            contatoListState.value = prestadorRepository.listarPrestadores()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroForm(
    nome: String,
    categoria: String,
    servicos: String,
    endereco: String,
    telefone: String,
    email: String,
    onNomeChange: (String) -> Unit,
    onCategoriaChange: (String) -> Unit,
    onServicosChange: (String) -> Unit,
    onEnderecoChange: (String) -> Unit,
    onTelefoneChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    atualizar: () -> Unit
) {
    //Obter contexto
    val context = LocalContext.current
    val prestadorRepository = PrestadorRepository(context)

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Cadastro de prestadores",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(
                0xFFE91E63
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = nome,
            onValueChange = { onNomeChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nome do prestador")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = categoria,
            onValueChange = { onCategoriaChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nome da categoria")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = servicos,
            onValueChange = { onServicosChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nome dos serviços")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = endereco,
            onValueChange = { onEnderecoChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Endereço")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = telefone,
            onValueChange = { onTelefoneChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Telefone do prestador")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { onEmailChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Email do prestador")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val prestador = Prestador(
                    nome = nome,
                    categoria = categoria,
                    servicos = servicos,
                    endereco = endereco,
                    email = email,
                    telefone = telefone
                )
                prestadorRepository.salvar(prestador)
                atualizar()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "CADASTRAR",
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun CadastroList(prestadores : List<Prestador>, atualizar: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        for (prestador in prestadores) {
            ContatoCard(prestador, atualizar)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
fun ContatoCard(prestador : Prestador, atualizar: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            val context = LocalContext.current
            val prestadorRepository = PrestadorRepository(context)
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
                prestadorRepository.excluir(prestador)
                atualizar()
            }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = ""
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CadastroScreenPreview(){
    val navController = rememberNavController()
    CadastroScreen(navController = navController)
}
