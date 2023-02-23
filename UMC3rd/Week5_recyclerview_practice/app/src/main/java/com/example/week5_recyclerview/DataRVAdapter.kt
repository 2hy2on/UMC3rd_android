package com.example.week5_recyclerview

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week5_recyclerview.databinding.ItemDataBinding

class DataRVAdapter(private val dataList: ArrayList<Data> = arrayListOf()): RecyclerView.Adapter<DataRVAdapter.DataViewHolder>() { //인자값으로 데이터리스트를 넣으면 메인에서 바꾸면 dataRVadaptor에서도 자동수정
    //private val dataList: ArrayList<Data> = arrayListOf()
    //ViewHolder객체
    inner class DataViewHolder(private val viewBinding: ItemDataBinding): RecyclerView.ViewHolder(viewBinding.root){ //viewholder은 onCreate에서 진행
        fun bind(data:Data) { //viewHolder가 어떤걸 표시할 때 호출 시켜주는함수 data class를 인자값으로, 뷰 설정
            viewBinding.tvTitle.text = data.title
            viewBinding.tvDesc.text = data.desc
        }
    }

    //viewholder 만들어질 실행할 동작, xml파일을 뷰홀더에 넣어주는 작업
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder { //onCreate 액티비티와 비슷 뷰를 설정하는 것은 bind에서 oncreate는 뷰홀더가 실제로 레이아웃 만듦
        val viewBinding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false) //attachToParent 부모에 붙이겠니?? true하면 오류, layoutInflater를 바로 가져올 수 없어서 부모의 context정보를 이용
        //main에 viewbinding과 하는짓 같음  layoutInflate를 바로 가져올 수 없어서 부모의 context정보 이용
        return DataViewHolder(viewBinding)
    }

    //viewHolder가 실제로 데이터를 표시해야 할 때 호출되는 함수, 실제로 데이터를 표시해야할 때(스크롤을 해서 포지션 바뀌었을때)
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    //표현할 아이템의 총 갯수
    override fun getItemCount(): Int = dataList.size

    override fun getItemViewType(position: Int): Int {
        return position
    }
}