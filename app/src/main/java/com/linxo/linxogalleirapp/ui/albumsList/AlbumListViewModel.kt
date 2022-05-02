package com.linxo.linxogalleirapp.ui.albumsList

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linxo.linxogalleirapp.ui.models.AlbumModel
import com.linxo.linxogalleirapp.usecases.GetListModelUsecase
import com.linxo.linxogalleirapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumListViewModel@Inject constructor(
    private val getListModelUsecase: GetListModelUsecase
) : ViewModel() {

    private val _listScreenState : MutableState<Resource<List<AlbumModel>>> = mutableStateOf(Resource.Loading)
    val listScreenState :State<Resource<List<AlbumModel>>> get() = _listScreenState

    init {
        getAlbumList()
    }

    private fun getAlbumList(){
        viewModelScope.launch {
            getListModelUsecase.invoke().collect{
                _listScreenState.value = it
            }
        }
    }
}

