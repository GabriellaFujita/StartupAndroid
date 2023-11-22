package br.com.fiap.startup.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.startup.model.Cliente

@Database(entities = [Cliente::class], version = 1)
abstract class ClienteDb: RoomDatabase() {

    abstract fun clienteDao(): ClienteDao

    //Singleton
    companion object {

        private lateinit var instance: ClienteDb

        fun getDatabase(context: Context): ClienteDb {
            if (!::instance.isInitialized) {
                instance = Room.databaseBuilder(context, ClienteDb::class.java,"cliente_db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration() //Destroi db antigo a cada criação, para testes
                    .build()
            }
            return instance
        }
    }
}