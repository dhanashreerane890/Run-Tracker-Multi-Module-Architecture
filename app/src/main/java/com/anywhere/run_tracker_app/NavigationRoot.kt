package com.anywhere.run_tracker_app

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.anywhere.auth.presentation.intro.IntroScreenRoot
import com.anywhere.auth.presentation.login.LoginScreenRoot
import com.anywhere.auth.presentation.register.RegisterScreenRoot
import com.anywhere.run.presentation.run_overview.ui.RunOverviewScreenRoot

@Composable
fun NavigationRoot(
    navController: NavHostController,
    isLoggedIn: Boolean
) {
    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) Routes.Run else Routes.Auth
    ) {
        authGraph(navController)
        runDataGraph(navController)
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation<Routes.Auth>(
        startDestination = Routes.Intro
    ) {
        composable<Routes.Intro> {
            IntroScreenRoot(
                onSignUpClick = {
                    navController.navigate(Routes.Register)
                },
                onSignInClick = {
                    navController.navigate(Routes.Login)
                }
            )
        }
        composable<Routes.Register> {
            RegisterScreenRoot(
                onSignInClick = {
                    navController.navigate(Routes.Login) {
                        popUpTo(Routes.Register) {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                onSuccessfulRegistration = {
                    navController.navigate(Routes.Login)
                }
            )
        }
        composable<Routes.Login> {
            LoginScreenRoot(
                onLoginSuccess = {
                    navController.navigate(Routes.Run) {
                        popUpTo(Routes.Auth) {  // Clears the entire authentication graph from backstack (Intro, Register, Login).
                            inclusive = true  // Removes the target screen itself
                        }
                    }
                },
                onSignUpClick = {
                    navController.navigate(Routes.Register) {
                        popUpTo(Routes.Login) {
                            inclusive = true //remove the Register screen itself from the back stack.
                            saveState = true // Saves the state of screens being popped
                        }
                        restoreState = true // Restores previously saved state on navigate
                    }
                }
            )
        }
    }
}

private fun NavGraphBuilder.runDataGraph(
    navController: NavHostController
) {

    navigation<Routes.Run>(
        startDestination = Routes.RunOverview,
    ) {
        composable<Routes.RunOverview> {
            RunOverviewScreenRoot(
                onLogoutClick = {
                    navController.navigate(Routes.Auth) {
                        popUpTo(Routes.Run) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}