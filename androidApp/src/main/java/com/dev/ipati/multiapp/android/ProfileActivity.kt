package com.dev.ipati.multiapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import com.dev.ipati.multiapp.compose.ProfilePage
import com.dev.ipati.multiapp.viewmodel.ProfileViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileActivity : ComponentActivity() {
    private val viewModel: ProfileViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BackHandler(onBack = {
                finishAfterTransition()
            })
            ProfilePage(viewModel)
        }
    }
}