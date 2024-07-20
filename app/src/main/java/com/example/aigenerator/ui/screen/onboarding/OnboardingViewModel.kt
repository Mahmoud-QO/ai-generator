package com.example.aigenerator.ui.screen.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aigenerator.data.datastore.PreferencesDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val preferences: PreferencesDataStore,
) : ViewModel() {

    private val _navigateToDiscover = MutableSharedFlow<Unit>()
    val navigateToDiscover = _navigateToDiscover.asSharedFlow()

    fun onEvent(event: OnboardingEvent) {
        when (event) {
            OnboardingEvent.ClickLetGo -> completeOnboarding()
        }
    }

    private fun completeOnboarding() = viewModelScope.launch {
        preferences.setOnboardingCompleted(true)
        _navigateToDiscover.emit(Unit)
    }
}

sealed class OnboardingEvent {
    data object ClickLetGo : OnboardingEvent()
}

