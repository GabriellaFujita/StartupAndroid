package br.com.fiap.startup.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "T_PRESTADOR")
data class Prestador(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var nome: String = "",
    var categoria: String = "",
    var servicos: String = "",
    var endereco: String = "",
    var telefone: String = "",
    var email: String = ""
)
