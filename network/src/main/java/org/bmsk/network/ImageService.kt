package org.bmsk.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageService {
    @Headers("Authorization: Client-ID $ACCESS_KEY")
    @GET("photos/random")
    fun getRandomImage(): Call<ImageResponse>
}