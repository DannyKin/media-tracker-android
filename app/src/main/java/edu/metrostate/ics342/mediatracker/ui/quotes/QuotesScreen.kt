package edu.metrostate.ics342.mediatracker.ui.quotes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import edu.metrostate.ics342.mediatracker.data.model.Quote



@Composable
fun QuotesScreen(
    viewModel: QuotesViewModel = viewModel()
) {
    val quotes by viewModel.quotes.collectAsState()
    val loading by viewModel.loading.collectAsState()
    val error by viewModel.error.collectAsState()

    var selectedQuote by remember {
        mutableStateOf<Quote?>(null)
    }

    var quoteToDelete by remember {
        mutableStateOf<Quote?>(null)
    }

    LaunchedEffect(Unit) {
        viewModel.loadQuotes()
    }

    when {
        loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        error != null -> {
            Text(
                text = error ?: "Couldn't load quotes."
            )
        }

        quotes.isEmpty() -> {
            Text(
                text = "No quotes saved yet — add one from a book's detail page."
            )
        }

        else -> {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(quotes) { quote ->

                    QuoteCard(
                        quote = quote,

                        onLikeToggle = {
                            viewModel.likeQuote(quote.id)
                        },

                        onEdit = {
                            selectedQuote = quote
                        },

                        onDelete = {
                            quoteToDelete = quote
                        }
                    )
                }
            }
        }
    }

    selectedQuote?.let { quote ->

        EditQuoteDialog(
            quote = quote,

            onDismiss = {
                selectedQuote = null
            },

            onSave = { request ->

                viewModel.updateQuote(
                    id = quote.id,
                    request = request
                )

                selectedQuote = null
            }
        )
    }
    quoteToDelete?.let { quote ->

        DeleteQuoteDialog(
            onConfirm = {
                viewModel.deleteQuote(quote.id)
                quoteToDelete = null
            },

            onDismiss = {
                quoteToDelete = null
            }
        )
    }
}