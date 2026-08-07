package edu.metrostate.ics342.mediatracker.ui.quotes

import edu.metrostate.ics342.mediatracker.data.model.CreateQuoteRequest
import edu.metrostate.ics342.mediatracker.data.model.Media
import edu.metrostate.ics342.mediatracker.data.model.MediaType
import edu.metrostate.ics342.mediatracker.data.model.Quote
import edu.metrostate.ics342.mediatracker.data.network.MediaRepository

class FakeQuoteRepository : MediaRepository {

    private val quotes = mutableListOf<Quote>()
    private var nextId = 1

    override suspend fun createQuote(
        request: CreateQuoteRequest
    ): Quote {

        val quote = Quote(
            id = nextId++,
            userId = 1,
            mediaId = request.mediaId,
            quoteText = request.quoteText,
            pageNumber = request.pageNumber,
            isPublic = request.isPublic,
            likeCount = 0,
            createdAt = "2026-08-06T00:00:00Z",
            media = Media(
                id = request.mediaId,
                mediaType = MediaType.BOOK,
                title = "Test Book",
                author = "Test Author",
                publishedYear = 2026,
                averageRating = 0f,
                ratingCount = 0,
                genres = emptyList()
            )
        )

        quotes.add(quote)

        return quote
    }

    override suspend fun getQuotes(): List<Quote> {
        return quotes.toList()
    }

    override suspend fun updateQuote(
        id: Int,
        request: CreateQuoteRequest
    ): Quote {
        val index = quotes.indexOfFirst { it.id == id }

        if (index == -1) {
            throw Exception("Quote not found")
        }

        val updated = quotes[index].copy(
            quoteText = request.quoteText,
            pageNumber = request.pageNumber,
            isPublic = request.isPublic
        )

        quotes[index] = updated

        return updated
    }

    override suspend fun deleteQuote(id: Int) {
        quotes.removeIf { it.id == id }
    }

    override suspend fun getPublicQuotes(): List<Quote> {
        return quotes.filter { it.isPublic }
    }

    override suspend fun likeQuote(id: Int) {
        val index = quotes.indexOfFirst { it.id == id }

        if (index >= 0) {
            quotes[index] = quotes[index].copy(
                likeCount = quotes[index].likeCount + 1
            )
        }
    }

    override suspend fun unlikeQuote(id: Int) {
        val index = quotes.indexOfFirst { it.id == id }

        if (index >= 0) {
            quotes[index] = quotes[index].copy(
                likeCount = maxOf(
                    0,
                    quotes[index].likeCount - 1
                )
            )
        }
    }
}