package gromov.numbersapi.numbers_feature.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import gromov.numberapitestcase.databinding.ItemNumberListBinding
import gromov.numberapitestcase.main_feature.presentation.model.NumberFactView

class NumberListAdapter : ListAdapter<NumberFactView, NumberListViewHolder>(NumberListDiffUtil) {

    var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberListViewHolder {
        val binding = ItemNumberListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NumberListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NumberListViewHolder, position: Int) {
        val number = getItem(position)
        with(holder.binding) {
            numberTv.text = number.number.toString()
            detailTv.text = number.text
            root.setOnClickListener {
                onClickListener?.onClick(number)
            }
        }
    }

    interface OnClickListener {
        fun onClick(number: NumberFactView)
    }
}