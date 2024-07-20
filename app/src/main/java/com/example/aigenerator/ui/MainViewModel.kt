package com.example.aigenerator.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aigenerator.data.datastore.PreferencesDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
	private val preferences: PreferencesDataStore
) : ViewModel() {

	private val _isOnboardingCompleted = MutableStateFlow<OnboardingState>(OnboardingState.Loading)
	val isOnboardingCompleted = _isOnboardingCompleted.asStateFlow()

	init {
		viewModelScope.launch {
			preferences.getOnboardingCompleted().collect {
				_isOnboardingCompleted.value =
					if (it) OnboardingState.Completed else OnboardingState.NotCompleted
			}
		}
	}

}

sealed class OnboardingState {
	data object Loading : OnboardingState()
	data object Completed : OnboardingState()
	data object NotCompleted : OnboardingState()
}