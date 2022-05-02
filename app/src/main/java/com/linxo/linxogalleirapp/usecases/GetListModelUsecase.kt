package com.linxo.linxogalleirapp.usecases

import com.linxo.linxogalleirapp.network.models.NetworkAlbums
import com.linxo.linxogalleirapp.network.models.NetworkUser
import com.linxo.linxogalleirapp.repository.LinxoGalleryRepository
import com.linxo.linxogalleirapp.ui.models.AlbumModel
import com.linxo.linxogalleirapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class GetListModelUsecase@Inject constructor(
    private val linxoGalleryRepository: LinxoGalleryRepository
) {
    suspend fun invoke(): Flow<Resource<List<AlbumModel>>> {
        return linxoGalleryRepository.getAlbums().flatMapConcat { resAlbum ->
            when (resAlbum) {
                is Resource.Error -> flowOf(Resource.Error(resAlbum.cause))
                Resource.Loading -> flowOf(Resource.Loading)
                is Resource.Success -> linxoGalleryRepository.getUsers().flatMapConcat { resUsers ->
                    when (resUsers) {
                        is Resource.Error -> flowOf(Resource.Error(resUsers.cause))
                        Resource.Loading -> flowOf(Resource.Loading)
                        is Resource.Success -> flowOf(
                            Resource.Success(
                                transformNetworkToModel(
                                    resAlbum.value,
                                    resUsers.value
                                )
                            )
                        )
                    }
                }
            }
        }
    }

    private fun transformNetworkToModel(albumList: List<NetworkAlbums>, userList: List<NetworkUser>): List<AlbumModel> {
       val alBumsModelList = mutableListOf<AlbumModel>()
        albumList.forEach { albums ->
            userList.forEach { user ->
                if(albums.userId == user.id){
                    alBumsModelList.add(AlbumModel(albums.id,albums.title,user.name))
                }
            }
        }
        return alBumsModelList.toList()
    }
}