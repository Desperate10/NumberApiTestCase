package gromov.numberapitestcase.main_feature.data.local.entity

import androidx.room.Entity

@Entity(tableName = "numbers", primaryKeys = ["number"])
data class NumberFactDbModel (
    val number: Int,
    val text: String
)