package com.anywhere.auth.presentation.login

//import app.cash.turbine.test
/*import com.anywhere.auth.domain.AuthRepository
import com.anywhere.auth.domain.UserDataValidator
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class LoginViewModelTest {

    private lateinit var authRepository: AuthRepository
    private lateinit var userDataValidator: UserDataValidator
    private lateinit var viewModel: LoginViewModel

    @Before
    fun setUp() {

        authRepository = mockk()
        userDataValidator = mockk()

    }


    @Test
    fun `validate email and password validation while entering in input`() = runTest {
        viewModel = LoginViewModel(authRepository, userDataValidator)
        viewModel.state.test {
            val result = awaitItem()
            assertEquals(false, result.canLogin)
            Assert.assertNotNull(result)
            cancelAndIgnoreRemainingEvents()
        }
    }

}*/
