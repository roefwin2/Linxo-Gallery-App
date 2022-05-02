package com.linxo.linxogalleirapp.ui.albumsgrid.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.linxo.linxogalleirapp.ui.albumsgrid.AlbumGalleryViewModel
import com.linxo.linxogalleirapp.utils.Resource
import kotlin.random.Random

@ExperimentalFoundationApi
@Composable
fun AlbumGalleryScreen(
    viewModel: AlbumGalleryViewModel = hiltViewModel()
) {
    val state = viewModel.galleryScreenState.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            contentPadding = PaddingValues(8.dp)
        ) {
            when (state) {
                is Resource.Error -> {
                }
                Resource.Loading -> {
                }
                is Resource.Success -> {
                    items(state.value) { item ->
                        Card(
                            modifier = Modifier.padding(4.dp),
                            backgroundColor = Color(
                                red = Random.nextInt(0, 255),
                                green = Random.nextInt(0, 255),
                                blue = Random.nextInt(0, 255)
                            )
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(item.photoUrl),
                                contentDescription = null,
                                modifier = Modifier.size(128.dp)
                            )
                        }
                    }
                }
            }
        }
    }

}