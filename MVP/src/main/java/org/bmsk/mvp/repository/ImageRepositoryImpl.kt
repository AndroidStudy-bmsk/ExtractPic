package org.bmsk.mvp.repository

import org.bmsk.network.ImageResponse
import org.bmsk.network.NetworkManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageRepositoryImpl : ImageRepository {
    override fun getRandomImage(callback: ImageRepository.Callback) {
        NetworkManager.imageService.getRandomImage()
            .enqueue(object : Callback<ImageResponse> {
                override fun onFailure(call: Call<ImageResponse>, t: Throwable) {}

                override fun onResponse(
                    call: Call<ImageResponse>,
                    response: Response<ImageResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            callback.loadImage(it.urls.regular, it.color)
                        }
                    }
                }
            })
    }
}