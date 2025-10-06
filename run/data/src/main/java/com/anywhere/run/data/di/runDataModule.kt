package com.anywhere.run.data.di

import com.anywhere.run.data.RunRepositoryImpl
import com.anywhere.run.domain.RunRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    singleOf(::RunRepositoryImpl).bind<RunRepository>()
}