package org.bmsk.mvi.repository

import org.bmsk.mvi.model.Image

interface ImageRepository {

    suspend fun getRandomImage(): Image
}