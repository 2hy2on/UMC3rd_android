package com.example.week5_rv_memo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week5_rv_memo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //private lateinit var getResultText:ActivityResultLauncher<Intent> //result함수를 사용하여 콜백 등록
    lateinit var viewBinding:ActivityMainBinding
    private var pos = 0
    val dataList: ArrayList<Data> = arrayListOf()
    val dataRVAdapter = DataRVAdapter(dataList)

    val getResultText = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            var title = result.data?.getStringExtra("title")!!
            var desc = result.data?.getStringExtra("desc")!!

            dataList.apply {
                add(Data(title.toString(), desc.toString()))
            }
            dataRVAdapter.notifyItemInserted(pos)
            pos++
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.addBtn.setOnClickListener {
            val mIntent = Intent(this, SecondActivity::class.java )
            getResultText.launch(mIntent)
        }

        viewBinding.rvData.adapter = dataRVAdapter
        viewBinding.rvData.layoutManager = LinearLayoutManager(this)
    }
}