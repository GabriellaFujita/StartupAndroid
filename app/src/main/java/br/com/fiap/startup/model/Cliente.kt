package br.com.fiap.startup.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "T_CLIENTE")
data class Cliente(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var nome: String = "",
    var dataNascimento: Date = Date(),
    var codigoUsuario: Int = 0
)
