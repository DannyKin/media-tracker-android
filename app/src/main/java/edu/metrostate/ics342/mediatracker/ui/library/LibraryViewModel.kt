package edu.metrostate.ics342.mediatracker.ui.library

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.metrostate.ics342.mediatracker.data.FakeMediaRepository
import edu.metrostate.ics342.mediatracker.data.FakeLibraryRepository
import edu.metrostate.ics342.mediatracker.data.LibraryRepository
import edu.metrostate.ics342.mediatracker.data.model.LibraryItem
import edu.metrostate.ics342.mediatracker.data.model.LibraryStatus
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LibraryViewModel(
    private val repository: LibraryRepository = FakeLibraryRepository()
) : ViewModel() {

    private val _libraryItems = MutableStateFlow<List<LibraryItem>>(emptyList())
    val libraryItems: StateFlow<List<LibraryItem>> = _libraryItems.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _filterState = MutableStateFlow(value = LibraryStatus.WANT_TO)
    val filterState: StateFlow<LibraryStatus> = _filterState.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()


    init {
        loadLibrary()
    }

    fun loadLibrary() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            try {
                _libraryItems.value = repository.getLibrary()
            } catch (e: Exception) {
                _errorMessage.value = "Couldn't load library."
            }

            _isLoading.value = false
        }
    }

    fun removeItem(mediaId: Int) {
        val backup = _libraryItems.value.find {
            it.mediaId == mediaId
        }

        _libraryItems.value = _libraryItems.value.filter { it.mediaId != mediaId }

        viewModelScope.launch {
            try {
                repository.removeFromLibrary(mediaId)

            } catch (e: Exception) {
                backup?.let { item ->
                    _libraryItems.value =
                        _libraryItems.value + item
                }

                _errorMessage.value =
                    "Couldn't remove item. Try again."
            }
        }
    }

    fun updateStatus(
        mediaId: Int,
        newStatus: LibraryStatus
    ) {
        val backup = _libraryItems.value


        _libraryItems.value =
            _libraryItems.value.map { item ->
                if (item.mediaId == mediaId) {
                    item.copy(status = newStatus)
                } else {
                    item
                }
            }

        viewModelScope.launch {
            try {
                repository.updateStatus(
                    mediaId,
                    newStatus
                )

            } catch (e: Exception) {
                _libraryItems.value = backup

                _errorMessage.value =
                    "Couldn't update status."
            }
        }
    }

    fun addToLibrary(media: LibraryItem) {

        _libraryItems.value =
            _libraryItems.value + media

        viewModelScope.launch {
            try {
                repository.addToLibrary(media)

            } catch (e: Exception) {
                _libraryItems.value =
                    _libraryItems.value.filter {
                        it.mediaId != media.mediaId
                    }

                _errorMessage.value =
                    "Couldn't add item."
            }
        }
    }
}