package com.example.myapplication.presentation.home.main_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.presentation.ui.theme.HintGray
import com.example.myapplication.presentation.ui.theme.SearchLightGray

@Composable
fun SearchBar(
    navController: NavController
) {
    Row {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null,
                modifier = Modifier.padding(15.dp, 12.dp, 20.dp, 0.dp),
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 9.dp, 16.dp, 0.dp),
        ) {
            SearchTextField()
        }
    }
}

@Preview
@Composable
fun SearchTextField() {
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    BasicTextField(
        modifier = Modifier
            .background(SearchLightGray, RoundedCornerShape(40.dp))
            .fillMaxWidth()
            .height(44.dp),
        value = textFieldValue,
        onValueChange = { textFieldValue = it },
        singleLine = true,
        textStyle = TextStyle(color = Color.Black, fontSize = 14.sp),
        decorationBox = { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(
                        R.drawable.ic_search_15
                    ),
                    contentDescription = null,
                    modifier = Modifier.padding(12.dp),
                    tint = HintGray
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    if (textFieldValue.text.isEmpty()) {
                        Text(
                            text = stringResource(R.string.search_hint),
                            style = TextStyle(color = HintGray, fontSize = 14.sp)
                        )
                    } else {
                        innerTextField()
                    }
                    IconButton(onClick = { textFieldValue = TextFieldValue("") }) {
                        Icon(
                            painter = painterResource(
                                R.drawable.ic_close_circle_line
                            ),
                            contentDescription = null,
                            modifier = Modifier.alpha(if (textFieldValue.text.isEmpty()) 0f else 1f),
                            tint = HintGray
                        )
                    }
                }
            }
        }
    )
}

//изменить падинг '1.2.0-alpha04'
//                    TextFieldDefaults.TextFieldDecorationBox(
//                        value = "value",
//                        visualTransformation = visualTransformation,
//                        innerTextField = innerTextField,
//                        singleLine = singleLine,
//                        enabled = enabled,
//                        interactionSource = interactionSource,
//                        contentPadding = PaddingValues(0.dp), // this is how you can remove the padding
//                    )

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