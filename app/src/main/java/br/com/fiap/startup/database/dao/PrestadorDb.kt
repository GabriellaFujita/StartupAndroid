package br.com.fiap.startup.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.startup.model.Prestador

@Database(entities = [Prestador::class], version = 1)
abstract class PrestadorDb: RoomDatabase() {

    abstract fun prestadorDao(): PrestadorDao

    //Singleton
    companion object {

        private lateinit var instance: PrestadorDb

        fun getDatabase(context: Context): PrestadorDb {
            if (!::instance.isInitialized) {
                instance = Room.databaseBuilder(context, PrestadorDb::class.java,"prestador_db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration() //Destroi db antigo a cada criação, para testes
                    .build()
            }
            return instance
        }
    }
}