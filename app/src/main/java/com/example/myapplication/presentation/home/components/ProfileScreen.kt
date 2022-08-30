package com.example.myapplication.presentation.home.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.common.transformToPhone
import com.example.myapplication.domain.model.ProfileInfo
import com.example.myapplication.domain.model.UserInfo
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.home.profile_screen.DialogProfile
import com.example.myapplication.presentation.ui.theme.Purple

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun ProfileScreen(profileInfo: ProfileInfo, mainViewModel: MainViewModel = hiltViewModel()) {
    val isOpenDialog = remember { mutableStateOf(false) }
    val errorMessage = remember { mutableStateOf("") }

    Column() {
        val userInfo = profileInfo.userInfo
        TopBarText(text = stringResource(R.string.profile))
        PhotoNameAndTag(userInfo)
        OtherUserDescription(userInfo)
        ButtonExit(isOpenDialog, errorMessage)
    }

    if (isOpenDialog.value) {
        DialogProfile(isOpenDialog, errorMessage, mainViewModel, profileInfo.token)
    }
}

@Composable
fun ButtonExit(isOpenDialog: MutableState<Boolean>, errorMessage: MutableState<String>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 0.dp, 0.dp, 65.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ErrorExitToast(errorMessage)
        Button(
            onClick = {
                isOpenDialog.value = true
            },
            modifier = Modifier.size(380.dp, 48.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            shape = RoundedCornerShape(0)
        ) {
            Text(
                text = stringResource(R.string.exit),
                color = Color.White
            )
        }
    }
}

@Composable
fun ErrorExitToast(errorMessage: MutableState<String>) {
    Column(
        modifier = Modifier
            .size(400.dp, 60.dp)
            .padding(0.dp, 0.dp, 0.dp, 15.dp),
    ) {
        if(errorMessage.value != "") {
            Text(
                text = errorMessage.value,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Purple)
                    .wrapContentHeight(align = Alignment.CenterVertically),
                color = Color.White,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun PhotoNameAndTag(userInfo: UserInfo) {
    Row(
        modifier = Modifier
            .size(380.dp, 140.dp)
    ) {
        AsyncImage(
            model = userInfo.avatar,
            contentDescription = null,
            modifier = Modifier
                .size(140.dp, 140.dp)
                .padding(12.dp)
        )
        Column(
            modifier = Modifier
                .size(380.dp, 150.dp)
                .padding(16.dp, 16.dp, 0.dp, 0.dp)
        ) {
            Text(text = userInfo.firstName, fontSize = 18.sp)
            Text(text = userInfo.lastName, fontSize = 18.sp)
            Text(
                text = "“${userInfo.about}”",
                modifier = Modifier.padding(0.dp, 12.dp, 0.dp, 0.dp),
                fontWeight = FontWeight.Bold,
                color = Color.LightGray
            )
        }
    }
}

@Composable
fun OtherUserDescription(userInfo: UserInfo) {
    TextOfOtherDescription(stringResource(R.string.city), userInfo.city)
    Divider(color = Color.LightGray)
    TextOfOtherDescription(stringResource(R.string.phone), userInfo.phone.transformToPhone())
    Divider(color = Color.LightGray)
    TextOfOtherDescription(stringResource(R.string.email), userInfo.email)
    Divider(color = Color.LightGray)
}

@Composable
fun TextOfOtherDescription(header: String, text: String) {
    Column() {
        Text(
            text = header,
            modifier = Modifier.padding(16.dp, 16.dp, 0.dp, 0.dp),
            color = Color.LightGray, fontSize = 12.sp
        )
        Text(
            text = text,
            modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 16.dp),
            fontSize = 18.sp
        )
    }
}