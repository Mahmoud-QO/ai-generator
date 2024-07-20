package com.example.aigenerator.ui.screen.paywall

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aigenerator.data.datastore.PreferencesDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaywallViewModel @Inject constructor(
    private val preferences: PreferencesDataStore,
) : ViewModel() {

    private val _navigateToDiscover = MutableSharedFlow<Unit>()
    val navigateToDiscover = _navigateToDiscover.asSharedFlow()

    fun onEvent(event: PaywallEvent) {
        when (event) {
            is PaywallEvent.ClickSubscribe -> subscribe()
        }
    }

    private fun subscribe() = viewModelScope.launch {
        preferences.setUserSubscribed(true)
        _navigateToDiscover.emit(Unit)
        Log.d("#####", "User subscribed")
    }
}

sealed class PaywallEvent {
    data object ClickSubscribe : PaywallEvent()
}