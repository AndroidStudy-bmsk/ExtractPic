package org.bmsk.mvc.model.provider

import org.bmsk.network.ImageResponse
import org.bmsk.network.NetworkManager
import retrofit2.Call
import retrofit2.Response

class ImageProvider(
    private val callback: Callback
) {

    fun getRandomImage() {
        NetworkManager.imageService.getRandomImage()
            .enqueue(object : retrofit2.Callback<ImageResponse> {
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

    interface Callback {
        fun loadImage(url: String, color: String)
    }
}