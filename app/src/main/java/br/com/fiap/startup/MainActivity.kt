package br.com.fiap.startup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.startup.screen.BuscaScreen
import br.com.fiap.startup.screen.CadastroScreen
import br.com.fiap.startup.screen.LoginScreen
import br.com.fiap.startup.screen.PrestadorScreen
import br.com.fiap.startup.ui.theme.StartUpTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.startup.model.Prestador


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartUpTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "cadastro") {
                        composable(route = "login") { LoginScreen(navController) }
                        composable(route = "busca") { BuscaScreen(navController) }
                        composable(route = "prestador/{prestador}") {
                            val id: String? =it.arguments?.getString("prestador", "0")
                            PrestadorScreen(navController, id!!)
                        }
                        composable(route = "cadastro") { CadastroScreen(navController) }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun BuscaScreenPreview() {
    val navController = rememberNavController()
    BuscaScreen(navController = navController)

}
