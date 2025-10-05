package com.anywhere.auth.presentation.intro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anywhere.auth.presentation.R
import com.anywhere.core.presentation.designsystem.components.RuniqueActionButton
import com.anywhere.core.presentation.designsystem.components.RuniqueOutlinedActionButton

@Composable
fun IntroScreenRoot(
    onSignUpClick: () -> Unit,
    onSignInClick: () -> Unit
) {
    IntroScreen(
        onAction = { action ->
            when (action) {
                IntroAction.OnSignInClick -> onSignInClick()
                IntroAction.OnSignUpClick -> onSignUpClick()
            }
        }
    )
}

@Composable
fun IntroScreen(
    onAction: (IntroAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .padding(bottom = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.welcome_to_runique),
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        RuniqueOutlinedActionButton(
            text = stringResource(id = R.string.sign_in),
            isLoading = false,
            onClick = {
                onAction(IntroAction.OnSignInClick)
            },
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        RuniqueActionButton(
            text = stringResource(id = R.string.sign_up),
            isLoading = false,
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onAction(IntroAction.OnSignUpClick)
            }
        )
    }
}

@Preview
@Composable
private fun IntroScreenPreview() {
    IntroScreen(
        onAction = {}
    )
}