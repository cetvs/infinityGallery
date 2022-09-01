package com.example.myapplication.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.myapplication.presentation.home.main_screen.HomeScreen
import com.example.myapplication.presentation.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.microseconds

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
//@AndroidEntryPoint
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
                    var isDelay by remember { mutableStateOf(true) }
                    if (isDelay) {
                        SplashScreen()
                    }
                    val profileInfo = mainViewModel.getLocalProfileInfo()

                    if (profileInfo == null) {
                        val context = LocalContext.current
                        if (isDelay) {
                            LaunchedEffect(Unit) {
                                delay(800.microseconds)
                                isDelay = false
                            }
                        } else {
                            val intent = Intent(this, RegistrationActivity::class.java)
                            context.startActivity(intent)
                            this.finish()
                        }
                    } else {
                        if (isDelay) {
                            LaunchedEffect(Unit) {
                                delay(800.microseconds)
                                isDelay = false
                            }
                        } else {
                            HomeScreen(profileInfo)
                        }
                    }
//                    val navController = rememberNavController()
//                    SearchScreen(navController, profileInfo!!.token)
                }
            }
        }
    }
}
