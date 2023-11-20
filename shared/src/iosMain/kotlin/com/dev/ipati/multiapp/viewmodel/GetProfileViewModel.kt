package com.dev.ipati.multiapp.viewmodel

import com.dev.ipati.multiapp.usecase.GetProfileUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

object GetProfileViewModel : KoinComponent {
    fun getProfileViewModel(): ProfileViewModel {
        return get<ProfileViewModel>()
    }

    fun getProfileUseCase(): GetProfileUseCase {
        return get<GetProfileUseCase>()
    }
}