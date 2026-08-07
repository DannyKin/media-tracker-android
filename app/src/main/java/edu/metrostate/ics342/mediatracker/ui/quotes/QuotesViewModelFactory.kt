package edu.metrostate.ics342.mediatracker.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.metrostate.ics342.mediatracker.data.network.MediaRepository

class QuotesViewModelFactory(
    private val repository: MediaRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {
        if (modelClass.isAssignableFrom(QuotesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return QuotesViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}