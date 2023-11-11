package br.com.fiap.startup.database.repository

import android.content.Context
import br.com.fiap.startup.database.dao.ClienteDb
import br.com.fiap.startup.model.Cliente

class ClienteRepository(context: Context) {

    var db = ClienteDb.getDatabase(context).clienteDao()

    fun salvar(cliente: Cliente): Long {
        return db.salvar(cliente = cliente)
    }

    fun atualizar(cliente: Cliente): Int {
        return db.atualizar(cliente = cliente)
    }

    fun excluir(cliente: Cliente): Int {
        return db.excluir(cliente = cliente)
    }

    fun buscarClientePeloId(id: Long): Cliente {
        return db.buscarClientePeloId(id)
    }

    fun listarClientes(): List<Cliente> {
        return db.listarClientes()
    }

}