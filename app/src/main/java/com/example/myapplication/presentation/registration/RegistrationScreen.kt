@file:OptIn(ExperimentalComposeUiApi::class)

package com.example.myapplication.presentation.registration

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
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
import com.example.domain.common.BAD_REQUEST
import com.example.domain.common.HAVE_NOT_INTERNET
import com.example.myapplication.R
import com.example.domain.model.ProfileRequestBody
import com.example.myapplication.presentation.MainActivity
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.home.components.TopBarText
import com.example.myapplication.presentation.ui.theme.Purple


@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Preview
@Composable
fun RegistrationScreen(
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val isClick by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val activity = (LocalContext.current as? Activity)
    val loginTextState = remember { mutableStateOf(TextFieldValue(text = "")) }
    val passwordTextState = remember { mutableStateOf("") }
    val errorMessage = remember { mutableStateOf("") }
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
                .height(450.dp)
                .padding(0.dp, 30.dp, 0.dp, 0.dp)
        ) {
            val source = remember { MutableInteractionSource() }
            val focusManager = LocalFocusManager.current
            if (source.collectIsPressedAsState().value) {
                loginTextState.value = TextFieldValue(text = "+7 (")
            }
            LoginTextField(loginTextState, source, focusManager, isClick)
            if (isClick && loginTextState.value.text.isBlank()) TextIfTextFieldIsEmpty()
            val isPasswordVisibleState = remember { mutableStateOf(false) }
            PasswordTextField(isPasswordVisibleState, passwordTextState, isClick)
            if (isClick && passwordTextState.value.isBlank()) TextIfTextFieldIsEmpty()
//            Image(
//                painter = painterResource(R.drawable.ic_surf_edu),
//                contentDescription = null,
//                modifier = Modifier.size(230.dp),
//                colorFilter = ColorFilter.tint(SurfEduColor)
//            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp, 0.dp, 0.dp, 15.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (errorMessage.value != "") {
                ErrorRequestToast(errorMessage)
            }
            LoginButton(mainViewModel, errorMessage, context, activity)
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun LoginButton(
    mainViewModel: MainViewModel,
    errorMessage: MutableState<String>,
    context: Context,
    activity: Activity?
) {
    Button(
        onClick = {
            val profileInfo = mainViewModel.getProfileInfo(
//                        ProfileRequestBody(
//                            loginTextState.value.phoneToString(),
//                            passwordTextState.value
//                        )
                //TODO("")
                ProfileRequestBody("+79876543219", "qwerty")
            )
            when (profileInfo.message) {
                null -> {
                    mainViewModel.insertProfileInfo(profileInfo.data!!)
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                    activity?.finish()
                }
                BAD_REQUEST -> {
                    errorMessage.value = "Логин или пароль введен неправильно"
                }
                HAVE_NOT_INTERNET -> {
                    errorMessage.value = "Отсутствует соединение с интернетом"
                }
            }
        },
        modifier = Modifier.size(380.dp, 48.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
    ) {
        Text(
            stringResource(R.string.ENTER),
            color = Color.White
        )
    }
}

@Composable
fun ErrorRequestToast(errorMessage: MutableState<String>) {
    Column(
        modifier = Modifier
            .size(400.dp, 60.dp)
            .padding(0.dp, 0.dp, 0.dp, 15.dp),
    ) {
        Text(
            text = errorMessage.value,
            modifier = Modifier
                .fillMaxSize()
                .background(Purple)
                .wrapContentHeight(align = CenterVertically),
            color = Color.White,
            textAlign = TextAlign.Center,
            )
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
