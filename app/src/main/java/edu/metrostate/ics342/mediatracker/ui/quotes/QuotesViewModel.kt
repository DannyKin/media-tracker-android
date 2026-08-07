package edu.metrostate.ics342.mediatracker.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.metrostate.ics342.mediatracker.data.model.AlreadyLikedException
import edu.metrostate.ics342.mediatracker.data.model.CreateQuoteRequest
import edu.metrostate.ics342.mediatracker.data.model.Quote
import edu.metrostate.ics342.mediatracker.data.network.MediaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class QuotesViewModel(
    private val repository: MediaRepository
) : ViewModel() {


    private val _quotes = MutableStateFlow<List<Quote>>(emptyList())
    val quotes = _quotes.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    private var likeRequestInProgress = false

    fun createQuote(request: CreateQuoteRequest) {
        viewModelScope.launch {
            try {
                val newQuote = repository.createQuote(request)

                _quotes.value = _quotes.value + newQuote

            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }

    fun loadQuotes() {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null

            try {
                _quotes.value = repository.getQuotes()
            } catch (e: Exception) {
                _error.value = e.message ?: "Couldn't load quotes."
            } finally {
                _loading.value = false
            }
        }
    }

    fun loadPublicQuotes() {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null

            try {
                _quotes.value = repository.getPublicQuotes()
            } catch (e: Exception) {
                _error.value = e.message ?: "Couldn't load public quotes."
            } finally {
                _loading.value = false
            }
        }
    }

    fun updateQuote(
        id: Int,
        request: CreateQuoteRequest
    ) {
        viewModelScope.launch {
            _loading.value = true
            try {
                val updated = repository.updateQuote(id, request)

                _quotes.value = _quotes.value.map {
                    if (it.id == id) updated else it
                }

            } catch (e: Exception) {
                _error.value = e.message
            }
            finally {
                _loading.value = false
            }
        }
    }

    fun deleteQuote(id: Int) {
        viewModelScope.launch {
            try {
                repository.deleteQuote(id)

                _quotes.value = _quotes.value.filter {
                    it.id != id
                }

            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }

    fun likeQuote(id: Int) {

        if (likeRequestInProgress) return

        likeRequestInProgress = true

        viewModelScope.launch {
            try {
                repository.likeQuote(id)
                _quotes.value = repository.getPublicQuotes()

            } catch (e: AlreadyLikedException) {
                // Already liked. Do nothing.
                // This prevents crashing or showing an error.
                return@launch

            }catch (e: Exception) {
                _error.value = e.message ?: "Failed to like quote."
            } finally {
                likeRequestInProgress = false
                _loading.value = false
            }
        }
    }

    fun unlikeQuote(id: Int) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null

            try {
                repository.unlikeQuote(id)
                _quotes.value = repository.getPublicQuotes()

            } catch (e: Exception) {
                _error.value = e.message ?: "Failed to unlike quote."

            } finally {
                _loading.value = false
            }
        }
    }
}