package com.linxo.linxogalleirapp.ui.albumsList.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.linxo.linxogalleirapp.ui.albumsList.AlbumListViewModel
import com.linxo.linxogalleirapp.utils.Resource

@Composable
fun AlbumListScreen(
    navController: NavController,
    viewModel: AlbumListViewModel = hiltViewModel(),
) {

    val state = viewModel.listScreenState.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            when (state) {
                is Resource.Error -> {
                }
                Resource.Loading -> {

                }
                is Resource.Success -> {
                    items(state.value) { album ->
                        AlbumListItem(album = album, onItemClick = {
                            navController.navigate("album_gallery_screen" + "/${album.albumId}")
                        })
                    }
                }
            }
        }
    }
}