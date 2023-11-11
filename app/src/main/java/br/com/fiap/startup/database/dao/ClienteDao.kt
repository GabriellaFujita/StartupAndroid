package br.com.fiap.startup.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.startup.model.Cliente

@Dao
interface ClienteDao {

    @Insert
    fun salvar(cliente: Cliente): Long

    @Update
    fun atualizar(cliente: Cliente): Int

    @Delete
    fun excluir(cliente: Cliente): Int

    @Query("SELECT * FROM T_CLIENTE WHERE id = :id")
    fun buscarClientePeloId(id: Long): Cliente


    //Devolve lista de clientes
    @Query("SELECT * FROM T_CLIENTE ORDER BY nome")
    fun listarClientes(): List<Cliente>
}