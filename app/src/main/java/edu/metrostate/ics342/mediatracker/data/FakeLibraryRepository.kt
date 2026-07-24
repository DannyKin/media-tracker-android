package edu.metrostate.ics342.mediatracker.data

import edu.metrostate.ics342.mediatracker.data.model.LibraryItem
import edu.metrostate.ics342.mediatracker.data.model.LibraryStatus


class FakeLibraryRepository : LibraryRepository {

    override suspend fun getLibrary(): List<LibraryItem> {
        return FakeMediaRepository.libraryItems
    }

    override suspend fun removeFromLibrary(mediaId: Int) {

    }

    override suspend fun updateStatus(
        mediaId: Int,
        status: LibraryStatus
    ) {

    }

    override suspend fun addToLibrary(item: LibraryItem) {

    }
}