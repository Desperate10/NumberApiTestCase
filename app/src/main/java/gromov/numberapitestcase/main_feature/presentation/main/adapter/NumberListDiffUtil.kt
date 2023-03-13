package gromov.numbersapi.numbers_feature.presentation.main.adapter

import androidx.recyclerview.widget.DiffUtil
import gromov.numberapitestcase.main_feature.presentation.model.NumberFactView

object NumberListDiffUtil: DiffUtil.ItemCallback<NumberFactView>() {

    override fun areItemsTheSame(oldItem: NumberFactView, newItem: NumberFactView): Boolean {
        return oldItem.number == newItem.number
    }

    override fun areContentsTheSame(oldItem: NumberFactView, newItem: NumberFactView): Boolean {
        return oldItem == newItem
    }
}