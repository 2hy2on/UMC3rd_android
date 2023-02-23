package com.example.week8

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week8.databinding.ItemDataBinding

class DataRVAdapter(private val dataList: ArrayList<Data> = arrayListOf()):RecyclerView.Adapter<DataRVAdapter.DataViewHolder>() {
    inner class DataViewHolder(private val viewBinding: ItemDataBinding):RecyclerView.ViewHolder(viewBinding.root){

        fun bind(data:Data){
            viewBinding.tvTitle.text = data.title
            viewBinding.tvDesc.text = data.desc
            viewBinding.star.setOnCheckedChangeListener{ buttonView, isChedked->

            }
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