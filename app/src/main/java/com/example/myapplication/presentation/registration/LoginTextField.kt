package com.example.myapplication.presentation.registration

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.myapplication.common.transformToPhone
import com.example.myapplication.presentation.ui.theme.Purple
import com.example.myapplication.presentation.ui.theme.RegistrationFieldBackground
import com.example.myapplication.presentation.ui.theme.RegistrationFocusedIndicatorColor
import com.example.myapplication.presentation.ui.theme.UpdateScreenGray

@ExperimentalComposeUiApi
@Composable
fun LoginTextField(
    loginTextState: MutableState<TextFieldValue>,
    source: MutableInteractionSource,
    focusManager: FocusManager,
    isClick: Boolean
) {
    var loginText by loginTextState
    TextField(
        value = loginText.transformToPhone(),
        onValueChange = { loginText = it },
        modifier = Modifier.fillMaxWidth(0.9f),
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
}