package edu.metrostate.ics342.mediatracker.ui.detail

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

import edu.metrostate.ics342.mediatracker.data.model.Media
import edu.metrostate.ics342.mediatracker.data.network.MediaApiService

// Define UI state
sealed class MediaDetailState {
    object Loading : MediaDetailState()
    data class Success(val media: Media?, val inLibrary: Boolean) : MediaDetailState()
    data class Error(val message: String) : MediaDetailState()
}

class MediaDetailViewModel(private val apiService: MediaApiService) : ViewModel() {
    private val _state = MutableStateFlow<MediaDetailState>(MediaDetailState.Loading)
    val state: StateFlow<MediaDetailState> = _state.asStateFlow()

    private val _mediaId = MutableStateFlow(-1)
    val mediaId: StateFlow<Int> = _mediaId.asStateFlow()


//class MediaDetailViewModel : ViewModel() {
//    // TODO (Week 7): Accept mediaId, call GET /media/{id}, expose MediaDetail state.
//    // Also call GET /library to load current status for this item.
//    private val _mediaId = MutableStateFlow(-1)
//    val mediaId: StateFlow<Int> = _mediaId.asStateFlow()

    fun setMediaId(id: Int) { _mediaId.value = id }
}

