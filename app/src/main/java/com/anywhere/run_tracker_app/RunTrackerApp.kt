package com.anywhere.run_tracker_app

import android.app.Application
import com.anywhere.auth.data.di.authDataModule
import com.anywhere.auth.presentation.di.authViewModelModule
import com.anywhere.core.data.di.coreDataModule
import com.anywhere.core.database.di.databaseModule
import com.anywhere.network.di.networkModule
import com.anywhere.run.data.di.runDataModule
import com.anywhere.run.presentation.di.runPresentationModule
import com.anywhere.run_tracker_app.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RunTrackerApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        //Initialize Koin in Application class
        startKoin {
            androidLogger()
            androidContext(this@RunTrackerApp)
            // load modules
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runPresentationModule,
                databaseModule,
                networkModule,
                runDataModule
            )
        }
    }
}