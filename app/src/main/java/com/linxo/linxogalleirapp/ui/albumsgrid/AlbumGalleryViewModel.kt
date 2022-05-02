package com.linxo.linxogalleirapp.ui.albumsgrid

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linxo.linxogalleirapp.ui.models.PictureModel
import com.linxo.linxogalleirapp.usecases.GetGalleryModelUsecase
import com.linxo.linxogalleirapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumGalleryViewModel@Inject constructor(
    private val getGalleryModelUsecase: GetGalleryModelUsecase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _galleryScreenState : MutableState<Resource<List<PictureModel>>> = mutableStateOf(
        Resource.Loading)
    val galleryScreenState : State<Resource<List<PictureModel>>> get() = _galleryScreenState

    init {
        savedStateHandle.get<String>("albumId")?.let { albumId ->
            getPictureList(albumId.toInt())
        }
    }

     private fun getPictureList(albumId :Int){
        viewModelScope.launch {
            getGalleryModelUsecase.invoke(albumId).collect{
                _galleryScreenState.value = it
            }
        }
    }
}