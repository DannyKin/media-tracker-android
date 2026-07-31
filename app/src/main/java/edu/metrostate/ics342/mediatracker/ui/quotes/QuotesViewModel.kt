package edu.metrostate.ics342.mediatracker.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.metrostate.ics342.mediatracker.data.model.Quote
import edu.metrostate.ics342.mediatracker.data.network.DefaultMediaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class QuotesViewModel(
    private val repository: DefaultMediaRepository
) : ViewModel() {


    private val _quotes = MutableStateFlow<List<Quote>>(emptyList())
    val quotes = _quotes.asStateFlow()

    fun loadQuotes() {
        viewModelScope.launch {
            _quotes.value = repository.getQuotes()
        }
    }
}