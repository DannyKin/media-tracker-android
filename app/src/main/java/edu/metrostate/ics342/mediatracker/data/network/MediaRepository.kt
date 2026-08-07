package edu.metrostate.ics342.mediatracker.data.network

import edu.metrostate.ics342.mediatracker.data.model.CreateQuoteRequest
import edu.metrostate.ics342.mediatracker.data.model.Quote

interface MediaRepository {

    suspend fun createQuote(
        request: CreateQuoteRequest
    ): Quote

    suspend fun getQuotes(): List<Quote>

    suspend fun updateQuote(
        id: Int,
        request: CreateQuoteRequest
    ): Quote

    suspend fun deleteQuote(
        id: Int
    )

    suspend fun getPublicQuotes(): List<Quote>

    suspend fun likeQuote(id: Int)

    suspend fun unlikeQuote(id: Int)
}