package br.com.fiap.startup.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.startup.R
import br.com.fiap.startup.LoginManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavController) {



    var loginState = remember {
        mutableStateOf("")
    }

    var senhaState = remember {
        mutableStateOf("")
    }


    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Transparent)) {
        ImageInBox()
        LoginForm(
            login = loginState.value,
            senha = senhaState.value,
            onLoginChange = {
                loginState.value = it
            },
            onSenhaChange = {
                senhaState.value = it
            },
            navController = navController
        )
        Button(onClick = { navController.navigate("busca") }) {
            Text("Ir para Busca")
        }
    }
}

@Composable
fun ImageInBox() {
    Box(
        modifier = Modifier.fillMaxWidth() // Largura igual à tela
            .height(100.dp),
        contentAlignment = Alignment.Center
    ) {
        // Carregue uma imagem de recurso
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null, // Descrição opcional para acessibilidade
            modifier = Modifier.fillMaxWidth().fillMaxHeight()
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginForm(
    login: String,
    senha: String,
    onLoginChange: (String) -> Unit,
    onSenhaChange: (String) -> Unit,
    navController: NavController
) {

    val loginManager = LoginManager(LocalContext.current)

    Column(modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF02112E)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = login,
            onValueChange = { onLoginChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Login")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = senha,
            onValueChange = { onSenhaChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Senha")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val loginEValido = loginManager.realizarLogin(login, senha) // Use o LoginManager para verificar o login
                if (loginEValido) {
                    // Login bem-sucedido, navegue para a próxima tela
                    navController.navigate("busca")
                } else {


                }
          },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "ENTRAR",
                modifier = Modifier.padding(8.dp)
            )
        }


    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview(){
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}