package edu.metrostate.ics342.mediatracker.data

import edu.metrostate.ics342.mediatracker.data.model.LibraryItem
import edu.metrostate.ics342.mediatracker.data.model.LibraryStatus


interface LibraryRepository {

    suspend fun getLibrary(): List<LibraryItem>

    suspend fun removeFromLibrary(
        mediaId: Int
    )

    suspend fun updateStatus(
        mediaId: Int,
        status: LibraryStatus
    )

    suspend fun addToLibrary(
        item: LibraryItem
    )
}