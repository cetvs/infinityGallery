package com.example.myapplication.presentation.main_app.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.myapplication.domain.model.ProfileInfo
import com.example.myapplication.domain.model.UserInfo
import com.example.myapplication.presentation.MainViewModel

@Composable
fun ProfileScreen(profileInfo: ProfileInfo, mainViewModel: MainViewModel = hiltViewModel()) {
    val isOpenDialog = remember { mutableStateOf(false) }
    Column() {
        val userInfo = profileInfo.userInfo
        TopBarText(text = "Профиль")
        PhotoNameAndTag(userInfo)
        Column(
            modifier = Modifier
                .fillMaxSize()
//                .background(Color.Red)
                .padding(0.dp, 0.dp, 0.dp, 65.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    isOpenDialog.value = true
                },
                modifier = Modifier.size(380.dp, 48.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
            ) {
                Text(
                    text = "Выход",
                    color = Color.White
                )
            }
        }
    }

    if (isOpenDialog.value) {
        AlertDialog(
            onDismissRequest = {
                isOpenDialog.value = false
            },
            title = {
                Text(
                    text = "Вы точно хотите выйти из приложения?",
                )
            },
            confirmButton = {
                Text(
                    text = "ДА, ТОЧНО",
                    modifier = Modifier
                        .clickable {
                            isOpenDialog.value = false
                            mainViewModel.postAuthLogout(profileInfo.token)
                        }
                        .padding(0.dp, 40.dp, 10.dp, 10.dp),
                )
            },
            dismissButton = {
                Text(
                    text = "НЕТ",
                    modifier = Modifier
                        .clickable { isOpenDialog.value = false }
                        .padding(0.dp, 40.dp, 0.dp, 0.dp),
                )
            }
        )
    }
}

@Composable
fun PhotoNameAndTag(userInfo: UserInfo) {
    Row() {
        AsyncImage(
            model = userInfo.avatar,
            contentDescription = null,
            modifier = Modifier.size(128.dp, 128.dp)
        )
        Column() {
            Text(text = userInfo.firstName)
            Text(text = userInfo.lastName)
        }
    }
}