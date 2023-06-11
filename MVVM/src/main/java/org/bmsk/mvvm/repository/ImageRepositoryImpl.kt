package org.bmsk.mvvm.repository

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.bmsk.mvvm.model.Image
import org.bmsk.network.MvvmRetrofitManager

class ImageRepositoryImpl : ImageRepository {
    override fun getRandomImage() = MvvmRetrofitManager.imageService.getRandomImageRx()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .flatMap { item ->
            Single.just(Image(item.urls.regular, item.color))
        }
}