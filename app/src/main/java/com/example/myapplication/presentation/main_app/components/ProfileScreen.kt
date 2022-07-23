package com.example.myapplication.presentation.main_app.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myapplication.domain.model.ProfileInfo
import com.example.myapplication.domain.model.UserInfo

@Composable
fun ProfileScreen(profileInfo: ProfileInfo) {
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