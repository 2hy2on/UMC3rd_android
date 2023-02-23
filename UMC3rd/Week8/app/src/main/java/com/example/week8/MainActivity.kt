package com.example.week8

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week8.Data
import com.example.week8.DataRVAdapter
import com.example.week8.SecondActivity
import com.example.week8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //private lateinit var getResultText:ActivityResultLauncher<Intent> //result함수를 사용하여 콜백 등록
    lateinit var viewBinding: ActivityMainBinding
    private var pos = 0
    var title:String ?=null
    var desc:String ?=null
    val dataList: ArrayList<Data> = arrayListOf()
    val dataRVAdapter = DataRVAdapter(dataList)

    private val getResultText = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            title = result.data?.getStringExtra("title")!!
            desc = result.data?.getStringExtra("desc")!!

            dataList.apply {
                add(Data(title.toString(), desc.toString()))
            }
            dataRVAdapter.notifyItemInserted(pos)
            pos++
            val roomDb = MemoDatabase.getInstance(this)
            if(roomDb != null)
            {
                val new = Memo(title!!, desc!!)
                roomDb.memoDao().insert(new)
                val list = roomDb.memoDao().selectAll()
                Log.d("DB", "User List: ${list}")
            }
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

        val roomDb = MemoDatabase.getInstance(this)
        if (roomDb != null) {
            for(pos in 1 until roomDb.memoDao().getCountMemo() + 1) {
                val title = roomDb?.memoDao()?.selectTitleByID(pos)
                val desc = roomDb?.memoDao()?.selectDescByID(pos)

                roomDb.memoDao().delete(Memo(title!!, desc!!))
                dataList.apply {
                    add(Data(title.toString(), desc.toString()))
                    //remove(Data(title.toString(), desc.toString()))
                }

                dataRVAdapter.notifyItemInserted(pos)
                Log.d("addData", "title: ${title}, des:${desc}")
            }
        }
       // val sharedPrefs = getSharedPreferences("sharedprefs", Context.MODE_PRIVATE)
        //val editor = sharedPrefs.edit()
        //editor.putString(, "android")
        //editor.apply()

    }
}