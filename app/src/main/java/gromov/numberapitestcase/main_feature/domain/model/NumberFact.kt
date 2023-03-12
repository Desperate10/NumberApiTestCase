package gromov.numberapitestcase.main_feature.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName

@Parcelize
data class NumberFact(
    @SerialName("number")
    val number: Int,
    @SerialName("text")
    val text: String
) : Parcelable
