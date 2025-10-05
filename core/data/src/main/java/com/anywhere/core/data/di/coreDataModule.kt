package com.anywhere.core.data.di

import com.anywhere.core.data.auth.EncryptedSessionStorage
import com.anywhere.core.data.networking.HttpClientFactory
import com.anywhere.core.data.run.RunRepositoryImpl
import com.anywhere.core.domain.SessionStorage
import com.anywhere.core.domain.run.RunRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
    singleOf(::RunRepositoryImpl).bind<RunRepository>()
}