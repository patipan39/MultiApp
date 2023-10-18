package com.dev.ipati.multiapp.compose.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.ipati.multiapp.style.FontWeight400

@Composable
fun Home(onClickedItem: (() -> Unit)? = null) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Black,
                        Color(0x877A51E2)
                    )
                )
            ),
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(Modifier.height(100.dp))
            Text(
                modifier = Modifier.padding(16.dp),
                style = FontWeight400(textSize = 32),
                text = "Hi Guest"
            )
            SearchField()
            ThumbnailCollection(onClickedItem)
        }
    }
}

@Composable
fun SearchField() {
    val searchValue = remember { mutableStateOf(SearchValue("")) }
    Box {
        TextField(
            modifier = Modifier.padding(horizontal = 16.dp),
            value = searchValue.value.value,
            onValueChange = {
                searchValue.value = SearchValue(it)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            placeholder = { Text("Search") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0x877A51E2),
                placeholderColor = Color(0XFF888D91),
                leadingIconColor = Color.White,
                textColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(20.dp),
            textStyle = FontWeight400(textSize = 16)
        )
    }
}

class SearchValue(val value: String)