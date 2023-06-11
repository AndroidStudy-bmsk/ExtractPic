package org.bmsk.mvi.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.bmsk.mvi.model.Image
import org.bmsk.network.NetworkManager

class ImageRepositoryImpl(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ImageRepository {

    override suspend fun getRandomImage() = withContext(dispatcher) {
        NetworkManager.imageService.getRandomImageSuspend().let {
            Image(it.urls.regular, it.color)
        }
    }
}