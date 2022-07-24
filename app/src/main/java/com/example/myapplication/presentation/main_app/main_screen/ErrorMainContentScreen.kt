package com.example.myapplication.presentation.main_app.main_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.main_app.components.TopBarText
import com.example.myapplication.presentation.ui.theme.UpdateScreenGray

@Composable
fun ErrorMainContentScreen(
    navController: NavController,
    token: String,
    mainViewModel: MainViewModel
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        TopBarText(text = "Галерея")
        Column(
            modifier = Modifier.fillMaxHeight(0.8f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                painter = painterResource(
                    R.drawable.ic_update_main_screen
                ),
                contentDescription = null,
                tint = UpdateScreenGray
            )
            Text(
                text = ERROR_TEXT,
                modifier = Modifier.padding(0.dp, 13.dp, 0.dp, 0.dp),
                textAlign = TextAlign.Center
            )
        }
        Button(
            onClick = { mainViewModel.getPictureInfo(token) }, Modifier.size(380.dp, 48.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
        ) {
            Text(
                stringResource(R.string.Update),
                color = Color.White
            )
        }
    }
}

const val ERROR_TEXT = "Не удалось загрузить ленту\n" +
        "Обновите экран или попробуйте позже"