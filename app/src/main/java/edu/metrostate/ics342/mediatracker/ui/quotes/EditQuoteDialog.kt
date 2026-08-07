package edu.metrostate.ics342.mediatracker.ui.quotes

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.*
import edu.metrostate.ics342.mediatracker.data.model.CreateQuoteRequest
import edu.metrostate.ics342.mediatracker.data.model.Quote

@Composable
fun EditQuoteDialog(
    quote: Quote,
    onDismiss: () -> Unit,
    onSave: (CreateQuoteRequest) -> Unit
) {
    var quoteText by remember {
        mutableStateOf(quote.quoteText)
    }

    var pageNumber by remember {
        mutableStateOf(
            quote.pageNumber?.toString() ?: ""
        )
    }

    AlertDialog(
        onDismissRequest = onDismiss,

        title = {
            Text("Edit Quote")
        },

        text = {
            Column {
                OutlinedTextField(
                    value = quoteText,
                    onValueChange = {
                        quoteText = it
                    },
                    label = {
                        Text("Quote")
                    }
                )

                OutlinedTextField(
                    value = pageNumber,
                    onValueChange = {
                        pageNumber = it
                    },
                    label = {
                        Text("Page Number")
                    }
                )
            }
        },

        confirmButton = {
            TextButton(
                onClick = {
                    onSave(
                        CreateQuoteRequest(
                            mediaId = quote.mediaId,
                            quoteText = quoteText,
                            pageNumber = pageNumber.toIntOrNull(),
                            isPublic = quote.isPublic
                        )
                    )
                    onDismiss()
                }
            ) {
                Text("Save")
            }
        },

        dismissButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text("Cancel")
            }
        }
    )
}
