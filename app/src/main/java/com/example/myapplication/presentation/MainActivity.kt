package com.example.myapplication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.presentation.home.main_screen.SearchScreen
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
                    var isDelay by remember { mutableStateOf(true) }
                    if (isDelay) {
                        SplashScreen()
                    }
                    val profileInfo = mainViewModel.getLocalProfileInfo()

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
                    val navController = rememberNavController()
                    SearchScreen(navController, profileInfo!!.token)
                }
            }
        }
    }
}
