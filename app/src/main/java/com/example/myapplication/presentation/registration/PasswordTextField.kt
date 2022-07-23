package com.example.myapplication.presentation.registration

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.presentation.ui.theme.Purple
import com.example.myapplication.presentation.ui.theme.RegistrationFieldBackground
import com.example.myapplication.presentation.ui.theme.RegistrationFocusedIndicatorColor
import com.example.myapplication.presentation.ui.theme.UpdateScreenGray

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