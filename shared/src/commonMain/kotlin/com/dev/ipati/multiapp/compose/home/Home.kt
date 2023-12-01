package com.dev.ipati.multiapp.compose.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.dev.ipati.multiapp.data.HomeResponse
import com.dev.ipati.multiapp.libsImage
import com.dev.ipati.multiapp.style.FontWeight400
import com.dev.ipati.multiapp.viewmodel.CommonViewModel
import com.multi.resource.SharedRes
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun Home(
    viewModel: CommonViewModel,
    onClickAlbum: (() -> Unit)? = null,
    onClickProfile: (() -> Unit)? = null
) {
    LaunchedEffect(viewModel.stateHome) {
        viewModel.getHomeComponent()
    }
    val component by viewModel.stateHome.collectAsState()
    val search by viewModel.search
    BaseHome(component, search, onClickAlbum, onClickProfile, onChangeSearch = {
        viewModel.search(it)
    })
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BaseHome(
    homeComponent: List<HomeResponse.Data>,
    search: String,
    onClickAlbum: (() -> Unit)? = null,
    onClickProfile: (() -> Unit)? = null,
    onChangeSearch: ((String) -> Unit)? = null
) {
    val homeState = rememberLazyListState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(
            top = 90.dp,
            bottom = 32.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        state = homeState
    ) {
        val paddingHorizontal = Modifier.padding(horizontal = 16.dp)
        val paddingVertical = Modifier.padding(vertical = 8.dp)
        stickyHeader {
            MenuHome(paddingHorizontal, onClickProfile)
        }
        item {
            TitleHome(paddingHorizontal, stringResource(SharedRes.strings.multi_app_welcome), 32)
        }
        item {
            SearchField(paddingHorizontal, search, onChange = {
                onChangeSearch?.invoke(it)
            })
        }
        //shelf section
        items(items = homeComponent, key = {
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
                onClickedItem = onClickAlbum
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
        libsImage().KamelImage(modifier = Modifier, url = url)
    }
}

@Composable
fun MenuHome(modifier: Modifier, onClicked: (() -> Unit)? = null) {
    Row(
        modifier = Modifier
            .then(modifier)
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.End,
    ) {
        Image(
            modifier = Modifier.clickable(onClick = {
                onClicked?.invoke()
            }),
            imageVector = Icons.Default.AccountCircle,
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color.White)
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