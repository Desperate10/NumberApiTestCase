package gromov.numberapitestcase.main_feature.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NumberFactView(
    val number: Int,
    val text: String
): Parcelable