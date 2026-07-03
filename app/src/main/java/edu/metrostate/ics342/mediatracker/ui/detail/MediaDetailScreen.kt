package edu.metrostate.ics342.mediatracker.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.keepScreenOn
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage

// ── STUB — Students build this in Week 7 ─────────────────────────────────────
//
// Week 7 task: Build the Media Detail screen.
//   1. Receive mediaId from the navigation argument (typed Int — see NavGraph).
//   2. Call GET /media/{mediaId} to load full details.
//   3. Display: cover image, title, creator credit, metadata grid, genre chips,
//      average rating, description, and a library status control.
//   4. Display the reviews list from GET /reviews?mediaId={id}.
//   5. Handle loading and error states (full-screen — no half-built screens).


@Composable
fun MediaDetailScreen(
    mediaId: Int,
    onNavigateBack: () -> Unit,
    onWriteReview: (Int) -> Unit
) {
    val n = viewModel.media

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .padding(all = 16.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.menu_book_24px),
            contentDescription = "Book cover",
            modifier = Modifier
                .size(width = 110.dp, height = 160.dp)
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape()
                )
                .padding(all = 24.dp),
            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onPrimaryContainer)
        )
        Text(m.title, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight S)

        val placeholder = when (detail.mediaType) {
            "book" -> R.drawable.menu_book_24px
            "movie" -> R.drawable.movie_24px
            "show" -> R.drawable.show_24px
            else -> R.drawable.tv_24px
        }
        Box(
            modifier = Modifier
                .size(width = 110.dp, height = 160.dp)
                .clip(shape = RoundedCornerShape(size = 12.dp))
                .background(containerColor),
            contentAlignment = Alignment.Center
        ) {
            if (detail.coverUrl != null) {
                AsyncImage(
                    model = detail.coverUrl,
                    contentDescription = detail.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                painter = painterResource(id = placeholder),
                contentDescription = null,
                modifier = Modifier.size(52.dp),
                tint = iconTint
            }

        }
    }
}
