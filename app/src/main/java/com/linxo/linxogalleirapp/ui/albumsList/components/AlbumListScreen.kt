package com.linxo.linxogalleirapp.ui.albumsList.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    if (state is Resource.Loading) {
        CircularProgressIndicator(
            modifier = Modifier
                .padding(30.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )
    }
    if (state is Resource.Error) {
        //TODO msg of error
    }
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            when (state) {
                is Resource.Success -> {
                    items(state.value) { album ->
                        AlbumListItem(album = album, onItemClick = {
                            navController.navigate("album_gallery_screen" + "/${album.albumId}")
                        })
                    }
                }
                else -> { //TODO handle exception
                }
            }
        }
    }
}