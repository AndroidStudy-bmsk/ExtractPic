package org.bmsk.mvi

import org.bmsk.mvi.model.Image

sealed class MviState {
    object Idle : MviState()
    object Loading : MviState()
    data class LoadedImage(val image: Image, val count: Int) : MviState()
}
