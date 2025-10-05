package com.anywhere.network.di

import com.anywhere.core.domain.run.IDummyRunDataSource
import com.anywhere.network.KtorDummyRunDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
//    singleOf(::KtorRemoteRunDataSource).bind<RemoteRunDataSource>()
    singleOf(::KtorDummyRunDataSource).bind<IDummyRunDataSource>()
}