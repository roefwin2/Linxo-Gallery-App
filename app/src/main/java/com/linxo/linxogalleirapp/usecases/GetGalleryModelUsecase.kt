package com.linxo.linxogalleirapp.usecases

import com.linxo.linxogalleirapp.network.models.NetworkPicture.Companion.toPictureModel
import com.linxo.linxogalleirapp.repository.LinxoGalleryRepository
import com.linxo.linxogalleirapp.ui.models.PictureModel
import com.linxo.linxogalleirapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetGalleryModelUsecase @Inject constructor(
    private val linxoGalleryRepository: LinxoGalleryRepository
) {
    suspend fun invoke(albumId: Int): Flow<Resource<List<PictureModel>>> {
        return linxoGalleryRepository.getPictures(albumId).map { it ->
            when (it) {
                is Resource.Error -> Resource.Error(it.cause)
                Resource.Loading -> Resource.Loading
                is Resource.Success -> Resource.Success(it.value.map { it.toPictureModel() })
            }
        }
    }
}