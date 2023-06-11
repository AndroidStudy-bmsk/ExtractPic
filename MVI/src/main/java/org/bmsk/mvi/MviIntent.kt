package org.bmsk.mvi

sealed class MviIntent {
    object LoadImage: MviIntent()
}
