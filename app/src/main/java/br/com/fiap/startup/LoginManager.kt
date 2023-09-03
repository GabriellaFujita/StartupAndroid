package br.com.fiap.startup
import android.content.Context
import androidx.annotation.RawRes
import br.com.fiap.startup.model.Usuario
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class LoginManager(private val context: Context) {

    fun realizarLogin(username: String, senha: String): Boolean {
        val usuariosJson = lerJsonDeRecursos(R.raw.usuarios) // Carregue o JSON de recursos
        val usuariosType = Types.newParameterizedType(List::class.java, Usuario::class.java)
        val moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<List<Usuario>> = moshi.adapter(usuariosType)

        val usuarios: List<Usuario>? = adapter.fromJson(usuariosJson)

        if (usuarios != null) {
            for (usuario in usuarios) {
                if (usuario.nomeUsuario == username && usuario.senha == senha) {
                    return true // Credenciais válidas
                }
            }
        }

        return false // Credenciais inválidas
    }

    private fun lerJsonDeRecursos(@RawRes resId: Int): String {
        return context.resources.openRawResource(resId).bufferedReader().use { it.readText() }
    }
}

