package com.example.myapplication.presentation.main_app.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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