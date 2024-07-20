package com.example.aigenerator.ui.screen.discover

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aigenerator.data.datastore.PreferencesDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val preferences: PreferencesDataStore,
) : ViewModel() {

    private val _isUserSubscribed = MutableStateFlow(false)

    private val _readyToGenerate = MutableStateFlow(false)
    val readyToGenerate = _readyToGenerate.asStateFlow()

    private val _navigateToPaywall = MutableSharedFlow<Unit>()
    val navigateToPaywall = _navigateToPaywall.asSharedFlow()

    fun onEvent(event: DiscoverEvent) {
        when (event) {
            is DiscoverEvent.ClickAddArt -> addArt()
            is DiscoverEvent.ClickClosePrompt -> hidePromptCard()
        }
    }

    private fun addArt() = viewModelScope.launch{
        checkUserSubscription()
        if (_isUserSubscribed.value) _readyToGenerate.emit(true)
        else _navigateToPaywall.emit(Unit)
    }

    private fun hidePromptCard() = viewModelScope.launch {
        _readyToGenerate.emit(false)
    }

    private fun checkUserSubscription() = viewModelScope.launch {
        preferences.getUserSubscribed().collect {
            _isUserSubscribed.emit(it)
        }
    }

}

sealed class DiscoverEvent {
    data object ClickAddArt : DiscoverEvent()
    data object ClickClosePrompt : DiscoverEvent()
}