package com.anywhere.auth.data.di

import com.anywhere.auth.data.EmailPatternValidator
import com.anywhere.auth.data.repo.DummyAuthRepositoryImpl
import com.anywhere.auth.domain.DummyAuthRepository
import com.anywhere.auth.domain.PatternValidator
import com.anywhere.auth.domain.UserDataValidator
import com.anywhere.core.database.user.UserDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

// module declare what can be injected.
val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    single {
        UserDatabase.getDatabase(get())
    }
    single { get<UserDatabase>().userDao() }

    //singleOf means create only one instance (singleton) of this class and share it everywhere in the ap
    //singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
    singleOf(::UserDataValidator)
    singleOf(::DummyAuthRepositoryImpl).bind<DummyAuthRepository>()

}