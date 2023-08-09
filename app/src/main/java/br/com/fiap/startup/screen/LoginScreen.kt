package br.com.fiap.startup.screen

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavController
import br.com.fiap.startup.database.repository.PrestadorRepository

@Composable
fun LoginScreen() {
    var loginState = remember {
        mutableStateOf("")
    }

    var senhaState = remember {
        mutableStateOf("")
    }

    Column {
        LoginForm(
            login = loginState.value,
            senha = senhaState.value,
            onLoginChange = {
                loginState.value = it
            },
            onSenhaChange = {
                senhaState.value = it
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginForm(
    login: String,
    senha: String,
    onLoginChange: (String) -> Unit,
    onSenhaChange: (String) -> Unit
) {

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Login",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(
                0xFFE91E63
            )
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
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* VAI PARA BUSCA SCREEN */ },
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
    LoginScreen()
}