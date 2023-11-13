package com.dev.ipati.multiapp.android

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dev.ipati.multiapp.compose.BaseTheme
import com.dev.ipati.multiapp.compose.home.Home

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseTheme {
                Home(onClickAlbum = {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }, onClickProfile = {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                })
            }
        }
    }
}