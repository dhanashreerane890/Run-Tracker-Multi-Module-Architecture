package com.anywhere.core.database.di

import androidx.room.Room
import com.anywhere.core.database.run.RoomLocalRunDataSource
import com.anywhere.core.database.run.RunDatabase
import com.anywhere.core.domain.run.LocalRunDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            RunDatabase::class.java,
            "run.db"
        ).build()
    }
    single { get<RunDatabase>().runDao }
    singleOf(::RoomLocalRunDataSource).bind<LocalRunDataSource>()
}