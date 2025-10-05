package com.anywhere.run.presentation.di

import com.anywhere.run.presentation.run_overview.RunOverviewViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val runPresentationModule = module {
    viewModelOf(::RunOverviewViewModel)
}