package com.dev.ipati.multiapp.compose.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.ipati.multiapp.style.FontWeight400

@Composable
fun BaseHome(onClickedItem: (() -> Unit)? = null) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Black,
                        Color(0x877A51E2)
                    )
                )
            ),
        contentPadding = PaddingValues(
            top = 100.dp,
            bottom = 32.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        val horizontalModifier = Modifier.padding(horizontal = 16.dp)
        item {
            TitleHome(horizontalModifier, "Hi Guest", 32)
        }
        item {
            SearchField(horizontalModifier)
        }
        item {
            TitleHome(horizontalModifier, "Albums", 20)
        }
        item {
            ThumbnailCollection(onClickedItem)
        }
    }
}

@Composable
fun TitleHome(modifier: Modifier = Modifier, text: String = "", textSize: Int) {
    Text(
        modifier = Modifier.then(modifier),
        text = text,
        style = FontWeight400(textSize = textSize)
    )
}

@Composable
fun SearchField(modifier: Modifier = Modifier) {
    val searchValue = remember { mutableStateOf(SearchValue("")) }
    Box {
        TextField(
            modifier = Modifier.then(modifier),
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