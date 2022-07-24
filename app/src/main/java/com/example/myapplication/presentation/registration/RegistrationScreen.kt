package com.example.myapplication.presentation.registration

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.R
import com.example.myapplication.domain.model.ProfileRequestBody
import com.example.myapplication.presentation.MainActivity
import com.example.myapplication.presentation.home.components.TopBarText
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.ui.theme.Purple


@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Preview
@Composable
fun RegistrationScreen(
    mainViewModel: MainViewModel = hiltViewModel()
) {
    var isClick by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val activity = (LocalContext.current as? Activity)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopBarText(text = "Вход")
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .height(545.dp)
                .padding(0.dp, 30.dp, 0.dp, 0.dp)
        ) {
            val source = remember { MutableInteractionSource() }
            val loginTextState = remember { mutableStateOf(TextFieldValue(text = "")) }
            val focusManager = LocalFocusManager.current
            if (source.collectIsPressedAsState().value) {
                loginTextState.value = TextFieldValue(text = "+7 (")
            }
            LoginTextField(loginTextState, source, focusManager, isClick)
            if (isClick && loginTextState.value.text.isBlank()) TextIfTextFieldIsEmpty()
            val isPasswordVisibleState = remember { mutableStateOf(false) }
            val passwordTextState = remember { mutableStateOf("") }
            PasswordTextField(isPasswordVisibleState, passwordTextState, isClick)
            if (isClick && passwordTextState.value.isBlank()) TextIfTextFieldIsEmpty()
        }
        Column(verticalArrangement = Arrangement.Bottom) {
            Button(
                onClick = {
                    if (false) {
                        isClick = true
                    } else {
                        val profileInfo = mainViewModel.getProfileInfo(
                            ProfileRequestBody("+79876543219", "qwerty")
                        )
                        mainViewModel.deleteProfileInfo()
                        mainViewModel.insertProfileInfo(profileInfo!!)
                        val intent = Intent(context, MainActivity::class.java)
                        context.startActivity(intent)
                        activity?.finish()
                    }
                },
                modifier = Modifier.size(380.dp, 48.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
            ) {
                Text(
                    stringResource(R.string.Update),
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun TextIfTextFieldIsEmpty() {
    Text(
        text = "Поле не может быть пустым",
        modifier = Modifier.fillMaxWidth(0.83f),
        color = Purple,
        fontSize = 10.sp,
        textAlign = TextAlign.Left
    )
}
