package com.hubert.spacexcomposeql.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Preview(showBackground = true)
@Composable
fun DetailScreen(item: DetailItem = DetailItem("site", "rakieta", "typ", true, "misja", "")) {
    Surface {
        Column {
            Logo(item.patch)
            Row {
                Column(modifier = Modifier.weight(0.5f)) {
                    Title(item.name)
                    Subtitle(item.site)
                }
                Column(modifier = Modifier.weight(0.5f)) {
                    Title(item.rocketName)
                    Subtitle(item.rocketType)
                }
            }
        }
    }
}

@Composable
fun Title(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(8.dp),
        style = MaterialTheme.typography.subtitle1
    )
}

@Composable
fun Subtitle(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(8.dp),
        style = MaterialTheme.typography.caption
    )
}

@Composable
fun Logo(url: String = "https://i.imgur.com/00xCRZ6.png") {
    Image(
        painter = rememberImagePainter(url),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .scale(0.7f),
        contentDescription = null,
        contentScale = ContentScale.FillHeight,
    )
}