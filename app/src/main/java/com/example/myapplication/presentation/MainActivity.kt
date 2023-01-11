package com.example.myapplication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import com.example.myapplication.domain.model.ProfileInfo
import com.example.myapplication.domain.model.UserInfo
import com.example.myapplication.presentation.home.main_screen.HomeScreen
import com.example.myapplication.presentation.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity() : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainViewModel: MainViewModel by viewModels()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen(mockProfileInfo())
                }
            }
//
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    var isDelay by remember { mutableStateOf(true) }
//                    if (isDelay) {
//                        SplashScreen()
//                    }
//                    val profileInfo = mainViewModel.getLocalProfileInfo()
//
//                    if (profileInfo == null) {
//                        val context = LocalContext.current
//                        if (isDelay) {
//                            LaunchedEffect(Unit) {
//                                delay(800.microseconds)
//                                isDelay = false
//                            }
//                        } else {
//                            val intent = Intent(this, RegistrationActivity::class.java)
//                            context.startActivity(intent)
//                            this.finish()
//                        }
//                    } else {
//                        if (isDelay) {
//                            LaunchedEffect(Unit) {
//                                delay(800.microseconds)
//                                isDelay = false
//                            }
//                        } else {
//                            HomeScreen(profileInfo)
//                        }
//                    }
//                }

        }
    }

    private fun mockProfileInfo(): ProfileInfo {
        return ProfileInfo(
            token = "23",
            userInfo = UserInfo(
                id = "2",
                phone = "+79518521812",
                email = "my@gmail.com",
                firstName = "Sergey",
                lastName = "Ivanov",
                avatar = "https://thumbs.dreamstime.com/b/creative-illustration-default-avatar-profile-placeholder-isolated-background-art-design-grey-photo-blank-template-mockup-144847501.jpg",
                city = "Moscow",
                about = "Информация обо мне"
            )
        )
    }
}
