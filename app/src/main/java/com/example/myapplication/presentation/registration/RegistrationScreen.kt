package com.example.myapplication.presentation.registration

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.presentation.TopBarText
import com.example.myapplication.presentation.ui.theme.Purple
import com.example.myapplication.presentation.ui.theme.RegistrationFieldBackground
import com.example.myapplication.presentation.ui.theme.RegistrationFocusedIndicatorColor
import com.example.myapplication.presentation.ui.theme.UpdateScreenGray

@ExperimentalComposeUiApi
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
            var loginText by remember { mutableStateOf(TextFieldValue(text = "")) }
            val focusManager = LocalFocusManager.current
            if (source.collectIsPressedAsState().value) {
                loginText = TextFieldValue(text = "+7 (")
            }
            TextField(
                value = loginText.transformToPhone(),
                onValueChange = { loginText = it },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .clickable { },
                label = { Text("Логин") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                interactionSource = source,
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.moveFocus(FocusDirection.Down) }
                ),
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = RegistrationFieldBackground,
                    cursorColor = Color.Black,
                    focusedLabelColor = UpdateScreenGray,
                    unfocusedLabelColor = UpdateScreenGray,
                    focusedIndicatorColor = if (isClick && loginText.text.isBlank())
                        Purple else RegistrationFocusedIndicatorColor,
                    unfocusedIndicatorColor = if (isClick && loginText.text.isBlank())
                        Purple else RegistrationFocusedIndicatorColor,
                ),
            )
            if (isClick && loginText.text.isBlank()) {
                TextIfTextFieldIsEmpty()
            }
            val isPasswordVisibleState = remember { mutableStateOf(false) }
            val passwordTextState = remember { mutableStateOf("") }
            PasswordTextField(isPasswordVisibleState, passwordTextState, isClick )
            if (isClick && passwordTextState.value.isBlank()) {
                TextIfTextFieldIsEmpty()
            }
        }
        Column(verticalArrangement = Arrangement.Bottom) {
            Button(
                onClick = {
                    isClick = true
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

@ExperimentalComposeUiApi
@Composable
fun PasswordTextField(
    isPasswordVisibleState: MutableState<Boolean>,
    passwordTextState: MutableState<String>,
    isClick: Boolean
) {
    var passwordText by passwordTextState
    var isPasswordVisible by isPasswordVisibleState
    val keyboardController = LocalSoftwareKeyboardController.current
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
        },
        keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = RegistrationFieldBackground,
            cursorColor = Color.Black,
            focusedLabelColor = UpdateScreenGray,
            unfocusedLabelColor = UpdateScreenGray,
            focusedIndicatorColor = if (isClick && passwordText.isBlank())
                Purple else RegistrationFocusedIndicatorColor,
            unfocusedIndicatorColor = if (isClick && passwordText.isBlank())
                Purple else RegistrationFocusedIndicatorColor,
        ),
    )
}

fun TextFieldValue.transformToPhone(): TextFieldValue {
    val str = this.text
    var result = "+7 ("
    val size = str.length

    var index = 4

    if (size > 4) {
        result += str[4]
        index = 5
    }

    if (size > 5) {
        result += str[5]
        index = 6
    }
    if (size > 6) {
        result += "${str[6]}) "
        index = 9
    }

    if (size > 9) {
        result += str[9]
        index = 10
    }
    if (size > 10) {
        result += str[10]
        index = 11
    }
    if (size > 11) {
        result += "${str[11]} "
        index = 13
    }

    if (size > 13) {
        result += str[13]
        index = 14
    }
    if (size > 14) {
        result += "${str[14]} "
        index = 16
    }

    if (size > 16) {
        result += str[16]
        index = 17
    }
    if (size > 17) {
        result += str[17]
        index = 18
    }
    return TextFieldValue(text = result, selection = TextRange(index))
}
