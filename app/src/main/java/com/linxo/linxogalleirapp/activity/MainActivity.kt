package com.linxo.linxogalleirapp.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.linxo.linxogalleirapp.ui.albumsList.AlbumListViewModel
import com.linxo.linxogalleirapp.ui.albumsList.components.AlbumListScreen
import com.linxo.linxogalleirapp.ui.albumsgrid.components.AlbumGalleryScreen
import com.linxo.linxogalleirapp.ui.models.AlbumModel
import com.linxo.linxogalleirapp.ui.theme.LinxoGallerieAppTheme
import com.linxo.linxogalleirapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LinxoGallerieAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "album_list_screen"
                    ) {
                        composable(
                            route = "album_list_screen"
                        ) {
                            AlbumListScreen(navController)
                        }
                        composable(
                            route = "album_gallery_screen" + "/{albumId}"
                        ) {
                            AlbumGalleryScreen()
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LinxoGallerieAppTheme {
    }
}


