package com.example.notassimples.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

// Base de dados Room da aplicação.
// version = 1 porque é a primeira versão.
@Database(
    entities = [NotaEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDb : RoomDatabase() {

    // O Room gera automaticamente a implementação do DAO.
    abstract fun notasDao(): NotasDao
}
