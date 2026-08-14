package edu.metrostate.ics342.mediatracker.ui.quotes

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import edu.metrostate.ics342.mediatracker.data.model.Quote

@Composable
fun QuoteCard(
    quote: Quote,
    modifier: Modifier = Modifier,
    onEdit: (() -> Unit)? = null,
    onDelete: (() -> Unit)? = null,
    onLikeToggle: (() -> Unit)? = null,
    liked: Boolean
) {

    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "\"${quote.quoteText}\"",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            quote.pageNumber?.let {
                Text(
                    text = "Page $it",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = quote.media.title,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {

                if (onLikeToggle != null) {
                    IconButton(
                        onClick = {
                            onLikeToggle.invoke()
                        }
                    ) {
                        Icon(
                            imageVector = if (liked) {
                                Icons.Default.Favorite
                            } else {
                                Icons.Default.FavoriteBorder
                            },
                            contentDescription = "Like"
                        )
                    }

                    Text(
                        text = quote.likeCount.toString(),
                        modifier = Modifier.padding(
                            top = 12.dp
                        )
                    )
                }

                if (onEdit != null) {
                    IconButton(
                        onClick = onEdit
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit quote"
                        )
                    }
                }

                if (onDelete != null) {
                    IconButton(
                        onClick = {
                            onDelete?.invoke()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete quote"
                        )
                    }
                }
            }
        }
    }
}