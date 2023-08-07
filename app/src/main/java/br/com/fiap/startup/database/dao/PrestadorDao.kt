package br.com.fiap.startup.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.startup.model.Prestador

@Dao
interface PrestadorDao {

    //Salvar devolve o id do prestador salvado
    @Insert
    fun salvar(prestador: Prestador): Long

    //Atualizar devolve a quantidade de prestadores atualizados
    @Update
    fun atualizar(prestador: Prestador): Int

    //Excluir devolve a quantidade de prestadores excluídos
    @Delete
    fun excluir(prestador: Prestador): Int

    //Devolve o prestador encontrado
    @Query("SELECT * FROM T_PRESTADOR WHERE id = :id")
    fun buscarPrestadorPeloId(id: Long): Prestador

    //Devolve lista de prestadores
    @Query("SELECT * FROM T_PRESTADOR WHERE categoria = :categoria")
    fun buscarPrestadorPelaCategoria(categoria: String): List<Prestador>

    //Devolve lista de prestadores
    @Query("SELECT * FROM T_PRESTADOR ORDER BY nome")
    fun listarPrestadores(): List<Prestador>

    //Devolve lista de prestadores
    @Query("SELECT * FROM T_PRESTADOR WHERE categoria = :categoria ORDER BY nome")
    fun listarPrestadoresPelaCategoria(categoria: String): List<Prestador>
}