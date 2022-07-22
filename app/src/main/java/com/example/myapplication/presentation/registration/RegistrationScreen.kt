package com.example.myapplication.presentation.registration

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.presentation.TopBarText
import com.example.myapplication.presentation.ui.theme.Purple

@Preview
@Composable
fun RegistrationScreen() {
    var isClick by remember { mutableStateOf(false) }
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
            var loginText by remember { mutableStateOf("") }
            if ( source.collectIsPressedAsState().value)
                loginText = "+7 ("
            TextField(
                value = loginText.transformToPhone(),
                onValueChange = { loginText = it },
                modifier = Modifier.fillMaxWidth(0.9f).clickable {  },
                label = { Text("Логин") },
                interactionSource = source
            )
            if (isClick && loginText.isBlank()) {
                TextIfTextFieldIsEmpty()
            }
            val isPasswordVisibleState = remember { mutableStateOf(false) }
            val passwordTextState = remember { mutableStateOf("") }
            PasswordTextField(isPasswordVisibleState, passwordTextState)
            if (isClick && passwordTextState.value.isBlank()) {
                TextIfTextFieldIsEmpty()
            }
        }
        Column(verticalArrangement = Arrangement.Bottom) {
            Button(
                onClick = { isClick = true }, Modifier.size(380.dp, 48.dp),
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
fun TextIfTextFieldIsEmpty(){
    Text(
        text = "Поле не может быть пустым",
        modifier = Modifier.fillMaxWidth(0.83f),
        color = Purple,
        fontSize = 10.sp,
        textAlign = TextAlign.Left
    )
}

@Composable
fun PasswordTextField(
    isPasswordVisibleState: MutableState<Boolean>,
    passwordTextState: MutableState<String>
) {
    var passwordText by passwordTextState
    var isPasswordVisible by isPasswordVisibleState
    TextField(
        value = passwordText,
        onValueChange = { passwordText = it },
        modifier = Modifier
            .padding(0.dp, 20.dp, 0.dp, 0.dp)
            .fillMaxWidth(0.9f),
        label = { Text("Пароль") },
        visualTransformation = if (isPasswordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val iconId = if (isPasswordVisible) {
                R.drawable.ic_visible_password
            } else {
                R.drawable.ic_unvisible_password
            }
            val description = if (isPasswordVisible) "Hide password" else "Show password"
            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                Icon(painter = painterResource(id = iconId), description)
            }
        }
    )
}

fun String.transformToPhone(): String {
    var result = "+7 ("
    val size = this.length
    if (size > 4)
        result += this[4]
    if (size > 5)
        result += this[5]
    if (size > 6)
        result += "${this[6]}) "

    if (size > 9)
        result += this[9]
    if (size > 10)
        result += this[10]
    if (size > 11)
        result += "${this[11]} "

    if (size > 13)
        result += this[13]
    if (size > 14)
        result += "${this[14]} "

    if (size > 16)
        result += this[16]
    if (size > 17)
        result += this[17]
    return result
}

//fun transformPhoneToString(phone: String): String {
//    var result = ""
//    val size = phone.length
//    if (size == 1)
//        return phone
//    if (size > 3) {
//        result += "${phone[3]}" +
////                "${if (size > 4) phone[4] else ""}" +
////                "${if (size > 5) phone[5] else ""}"
//    }
//    return result
//}