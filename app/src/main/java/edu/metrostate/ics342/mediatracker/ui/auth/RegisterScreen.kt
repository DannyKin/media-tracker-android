package edu.metrostate.ics342.mediatracker.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.sensitiveContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.metrostate.ics342.mediatracker.R
import edu.metrostate.ics342.mediatracker.theme.OnPrimaryContainer
import edu.metrostate.ics342.mediatracker.theme.OnSurface
import edu.metrostate.ics342.mediatracker.theme.PrimaryContainer

@Composable
fun RegisterScreen(
    onRegisterSuccess: () -> Unit,
    onNavigateToLogin: () -> Unit,
    viewModel: RegisterViewModel = viewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment   = Alignment.CenterHorizontally
    ) {
            Image(
                painterResource(id = R.drawable.smart_display),
                contentDescription = "Application Icon",
                modifier = Modifier
                    .size(width= 64.dp, height=64.dp)
                    .background(color= PrimaryContainer, shape = RoundedCornerShape(size= 12.dp))
                    .padding(all=12.dp),
                colorFilter = ColorFilter.tint(color = OnPrimaryContainer)
            )
        Text("Create Account")
        OutlinedTextField(
            state = TextFieldState(),

        )
        TextField(
            state = TextFieldState(),
            )
        TextField(
            state = TextFieldState(),

            )
        SecureTextField(
            state = TextFieldState(),
            modifier = Modifier,
            placeholder = {
                Text("Password")
            }

            )
        SecureTextField(
            state = TextFieldState(),
            placeholder ={
                Text("Confirm Password")
            }

            )
        Button( {
            viewModel.onSignupClicked()
        }) {
            Text("Sign Up")
        }

    }
}

@Composable
@Preview(showSystemUi = true)
fun RegisterScreenPreview() {
    RegisterScreen({}, {})
}