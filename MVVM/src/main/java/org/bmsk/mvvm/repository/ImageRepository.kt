package org.bmsk.mvvm.repository

import io.reactivex.Single
import org.bmsk.mvvm.model.Image

interface ImageRepository {
    fun getRandomImage() : Single<Image>
}