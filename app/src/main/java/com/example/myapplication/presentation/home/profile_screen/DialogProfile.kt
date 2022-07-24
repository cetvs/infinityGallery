package com.example.myapplication.presentation.home.profile_screen

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.RegistrationActivity

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun DialogProfile(isOpenDialog: MutableState<Boolean>, mainViewModel: MainViewModel, token: String) {
    val context = LocalContext.current
    val activity = (LocalContext.current as? Activity)
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
                        if (mainViewModel.postAuthLogout(token)) {
                            mainViewModel.deleteProfileInfo()
                            //TODO("delete favorite")
                            val intent = Intent(context, RegistrationActivity::class.java)
                            context.startActivity(intent)
                            activity?.finish()
                        }
                        else{
                            //TODO("TOAST")
                        }
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