package com.dev.ipati.multiapp.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dev.ipati.multiapp.LibsImage
import com.dev.ipati.multiapp.data.ProfileData
import com.dev.ipati.multiapp.style.FontWeight400
import com.dev.ipati.multiapp.viewmodel.ProfileViewModel
import com.multi.resource.SharedRes
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import dev.icerock.moko.mvvm.livedata.compose.observeAsState
import dev.icerock.moko.resources.compose.colorResource
import org.koin.mp.KoinPlatform

@Composable
fun ProfilePage() {
    val viewModel: ProfileViewModel = getViewModel(Unit, viewModelFactory {
        ProfileViewModel(
            KoinPlatform.getKoin().get()
        )
    })
    val profile by viewModel.currentLoginSocial.observeAsState()
    BaseProfile(profile)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseProfile(profile: ProfileData) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "ข้อมูลส่วนตัว",
                        style = FontWeight400(textSize = 16),
                        textAlign = TextAlign.Center
                    )
                }, navigationIcon = {
                    IconButton(
                        onClick = {
                        }, content = {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = null,
                                tint = Color.White
                            )
                        })
                }, colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )
        }, content = { paddingValues ->
            BaseTheme {
                LazyColumn(
                    modifier = Modifier.padding(paddingValues),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    content = {
                        //add ui profile
                        item {
                            ImageProfile("https://cdn-icons-png.flaticon.com/512/3135/3135715.png")
                        }

                        item {
                            val modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                            Title(modifier, "รอ Api นะ", textAlign = TextAlign.Center)
                        }

                        item {
                            Title(text = "บัญชีที่ใช้เข้าสู่ระบบ")
                        }

                        items(profile.currentProfile) {
                            CardChannelLogin(socialUrl = it.imageUrl, it.channelName, it.name)
                        }

                        item {
                            Title(text = "เชื่อมต่อด้วยบัญชีอื่น")
                        }

                        items(profile.otherProfile) {
                            CardChannelLogin(socialUrl = it.imageUrl, it.channelName, it.name)
                        }
                    })
            }
        })
}

@Composable
private fun ImageProfile(url: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .wrapContentHeight()
                .size(120.dp, 120.dp),
            shape = RoundedCornerShape(50),
            content = {
                LibsImage.KamelImage(modifier = Modifier, url = url)
            })
    }
}

@Composable
private fun Title(
    modifier: Modifier = Modifier,
    text: String = "",
    textAlign: TextAlign = TextAlign.Start,
    size: Int = 16
) {
    Text(
        modifier = Modifier.then(modifier),
        text = text,
        style = FontWeight400(textSize = size),
        textAlign = textAlign,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
private fun CardChannelLogin(socialUrl: String, channelName: String, name: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(16.dp),
        color = colorResource(SharedRes.colors.profile_background_item),
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            LibsImage.KamelImage(modifier = Modifier.size(48.dp, 48.dp), url = socialUrl)
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Title(text = channelName)
                Title(text = name, size = 12)
            }
        }
    }
}

