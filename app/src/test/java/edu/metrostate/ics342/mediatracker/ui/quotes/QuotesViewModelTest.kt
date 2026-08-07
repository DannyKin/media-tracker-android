package edu.metrostate.ics342.mediatracker.ui.quotes

import edu.metrostate.ics342.mediatracker.data.model.CreateQuoteRequest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.advanceUntilIdle
import org.junit.Assert.assertEquals
import org.junit.Test

class QuotesViewModelTest {

    @Test
    fun createQuote_updatesQuotesList() = runTest {

        val repository = FakeQuoteRepository()
        val viewModel = QuotesViewModel(repository)

        viewModel.createQuote(
            CreateQuoteRequest(
                mediaId = 1,
                quoteText = "Test quote",
                pageNumber = 5,
                isPublic = true
            )
        )

        advanceUntilIdle()

        assertEquals(
            1,
            viewModel.quotes.value.size
        )
    }
}