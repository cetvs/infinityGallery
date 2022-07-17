package com.example.myapplication.presentation.main_app.main_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.presentation.ui.theme.HintGray
import com.example.myapplication.presentation.ui.theme.SearchLightGray

@Preview
@Composable
fun SearchCompose() {
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    Row {
        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = null,
            modifier = Modifier.padding(14.dp, 17.dp, 20.dp, 0.dp),
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 9.dp, 16.dp, 0.dp),
        ) {
            BasicTextField(
                modifier = Modifier
                    .background(
                        SearchLightGray, RoundedCornerShape(40.dp)
                    )
                    .fillMaxWidth()
                    .height(47.dp),
                value = textFieldValue,
                onValueChange = {
                    textFieldValue = it
                },
                singleLine = true,
//                cursorBrush = Color.White,
                textStyle = TextStyle(color = Color.Black, fontSize = 14.sp),
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(
                                R.drawable.ic_search_15
                            ),
                            contentDescription = null,
                            tint = Color.White
                        )
                        if (textFieldValue.text.isEmpty()) {
                            Text(
                                text = "Поиск",
                                style = TextStyle(color = HintGray, fontSize = 14.sp)
                            )
                        }
                        innerTextField()
                    }
                }
            )
        }
    }
}

//BasicTextField(
//    value = text,
//    onValueChange = { value ->
//        text = value
//    },
//    modifier = Modifier
//    .clip(shape = RoundedCornerShape(40.dp))
//    //                    .height(38.dp)
//    .fillMaxWidth(),
//    textStyle = TextStyle(color = Color.White, fontSize = 14.sp),
//    colors = TextFieldDefaults.textFieldColors(
//    textColor = Color.White,
//    cursorColor = Color.White,
//    leadingIconColor = Color.White,
//    trailingIconColor = Color.White,
//    backgroundColor = Color.LightGray,
//    focusedIndicatorColor = Color.Transparent,
//    unfocusedIndicatorColor = Color.Transparent,
//    disabledIndicatorColor = Color.Transparent
//    )
//)



//    TextField(
//        value = textFieldValue,
//        onValueChange = { textFieldValue = it },
//        leadingIcon = {
//            Icon(
//                painter = painterResource(
//                    R.drawable.ic_search_15
//                ),
//                contentDescription = null,
//                tint = HintGray
//            )
//        },
//        textStyle = TextStyle(color = Color.Black, fontSize = 14.sp),
//        colors = TextFieldDefaults.textFieldColors(
//            backgroundColor = MaterialTheme.colors.surface
//        ),
//        placeholder = {
//            Text("Поиск")
//        },
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(56.dp)
////                    .heightIn(min = 50.dp)
//    )
//}