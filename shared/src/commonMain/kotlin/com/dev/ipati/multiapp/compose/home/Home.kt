package com.dev.ipati.multiapp.compose.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.dev.ipati.multiapp.CommonViewModel
import com.dev.ipati.multiapp.style.FontWeight400
import com.seiko.imageloader.rememberImagePainter
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import org.koin.mp.KoinPlatform

@Composable
fun BaseHome(onClickedItem: (() -> Unit)? = null) {
    val viewModel: CommonViewModel = getViewModel(
        Unit, viewModelFactory {
            CommonViewModel(KoinPlatform.getKoin().get())
        })
    val component by viewModel.stateHome
    val search by viewModel.search
    val homeState = rememberLazyListState()
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
        state = homeState
    ) {
        val paddingHorizontal = Modifier.padding(horizontal = 16.dp)
        val paddingVertical = Modifier.padding(vertical = 8.dp)
        item {
            TitleHome(paddingHorizontal, "Hi Guest", 32)
        }
        item {
            SearchField(paddingHorizontal, search, onChange = {
                viewModel.search(it)
            })
        }
        //shelf section
        items(items = component, key = {
            it.id.orEmpty()
        }) {
            it.banner.takeIf { url -> !url.isNullOrEmpty() }?.let { url ->
                TitleHome(
                    paddingHorizontal
                        .then(Modifier.padding(top = 8.dp)),
                    it.name.orEmpty(),
                    20
                )
                BannerHome(paddingHorizontal, url)
            } ?: run {
                TitleHome(
                    paddingHorizontal
                        .then(paddingVertical),
                    it.name.orEmpty(),
                    20
                )
            }
            ThumbnailCollection(
                albums = it.songList ?: emptyList(),
                onClickedItem = onClickedItem
            )
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
fun BannerHome(modifier: Modifier = Modifier, url: String = "") {
    Surface(
        modifier = Modifier.fillMaxWidth()
            .padding(
                vertical = 8.dp
            )
            .then(modifier),
        shape = RoundedCornerShape(22.dp)
    ) {
        Image(
            painter = rememberImagePainter(url),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
}

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    search: String = "",
    onChange: ((String) -> Unit)? = null
) {
    val focusManager = LocalFocusManager.current
    Box {
        TextField(
            modifier = Modifier
                .height(51.dp)
                .then(modifier),
            value = search,
            onValueChange = {
                onChange?.invoke(it)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            placeholder = {
                Text("Search")
            },
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
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done,
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus(true)
                })
        )
    }
}