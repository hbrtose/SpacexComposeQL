package com.hubert.spacexcomposeql.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage

@Composable
fun ListScreen(
    launches: State<List<LaunchItem>?>,
    onItemClick: (Int) -> Unit,
    onLastItemLoaded: () -> Unit
) {
    LazyColumn {
        itemsIndexed(launches.value ?: emptyList()) { index, item ->
            if (index == (launches.value?.size ?: 0) - 1) {
                onLastItemLoaded()
            }
            Item(item, onItemClick)
        }
    }
}

@Composable
fun Title(text: String = "TITLE") {
    Text(
        text = text,
        modifier = Modifier.padding(PaddingValues.Absolute(8.dp, 8.dp, 8.dp)),
        style = MaterialTheme.typography.body1
    )
}

@Composable
fun Subtitle(text: String = "SUBTITLE") {
    Text(
        text = text, 
        modifier = Modifier.padding(8.dp),
        style = MaterialTheme.typography.caption
    )
}

@Composable
fun Logo(url: String = "https://i.imgur.com/00xCRZ6.png") {
    SubcomposeAsyncImage(
        model = url,
        modifier = Modifier
            .size(64.dp)
            .padding(4.dp)
            .clip(CircleShape),
        contentDescription = null,
        contentScale = ContentScale.Fit,
    )
}

@Preview(showBackground = true)
@Composable
fun Item(item: LaunchItem = LaunchItem(1, "t", "s", "https://i.imgur.com/00xCRZ6.png"), onItemClick: (Int) -> Unit = {}) {
    Surface {
        Row(modifier = Modifier.fillMaxWidth().clickable {
            onItemClick(item.id)
        }) {
            Logo(item.icon)
            Column {
                Title(item.name)
                Subtitle(item.site)
            }
        }
    }
}