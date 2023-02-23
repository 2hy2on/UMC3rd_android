package com.example.week5_rv_memo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week5_rv_memo.databinding.ItemDataBinding

class DataRVAdapter(private val dataList: ArrayList<Data> = arrayListOf()):RecyclerView.Adapter<DataRVAdapter.DataViewHolder>() {
    inner class DataViewHolder(private val viewBinding: ItemDataBinding):RecyclerView.ViewHolder(viewBinding.root){

        fun bind(data:Data){
            viewBinding.tvTitle.text = data.title
            viewBinding.tvDesc.text = data.desc
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return DataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    override fun getItemViewType(position: Int): Int {
        return position
    }


}