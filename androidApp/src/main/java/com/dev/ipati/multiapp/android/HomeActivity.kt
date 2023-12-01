package com.dev.ipati.multiapp.android

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dev.ipati.multiapp.compose.BaseTheme
import com.dev.ipati.multiapp.compose.home.BaseHome
import com.dev.ipati.multiapp.compose.home.Home
import com.dev.ipati.multiapp.viewmodel.CommonViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : ComponentActivity() {
    private val viewModel: CommonViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseTheme {
                Home(viewModel = viewModel,
                    onClickAlbum = {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }, onClickProfile = {
                        val intent = Intent(this, ProfileActivity::class.java)
                        startActivity(intent)
                    })
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    private fun PreviewHome() {
        BaseHome(emptyList(), "Hello")
    }
}