package br.com.fiap.startup.database.repository

import android.content.Context
import br.com.fiap.startup.database.dao.PrestadorDb
import br.com.fiap.startup.model.Prestador

class PrestadorRepository(context: Context) {

    var db = PrestadorDb.getDatabase(context).prestadorDao()

    fun salvar(prestador: Prestador): Long {
        return db.salvar(prestador = prestador)
    }

    fun atualizar(prestador: Prestador): Int {
        return db.atualizar(prestador = prestador)
    }

    fun excluir(prestador: Prestador): Int {
        return db.excluir(prestador = prestador)
    }

    fun buscarPrestadorPeloId(id: Long): Prestador {
        return db.buscarPrestadorPeloId(id)
    }

    fun buscarPrestadorPelaCategoria(categoria: String): List<Prestador> {
        return db.buscarPrestadorPelaCategoria(categoria = categoria)
    }

    fun listarPrestadores(): List<Prestador> {
        return db.listarPrestadores()
    }

    fun listarPrestadoresPelaCategoria(categoria: String): List<Prestador> {
        return db.listarPrestadoresPelaCategoria(categoria = categoria)
    }
}