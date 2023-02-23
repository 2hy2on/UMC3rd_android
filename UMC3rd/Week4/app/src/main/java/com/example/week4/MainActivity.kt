package com.example.week4

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.week4.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    var memo: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveBtn.setOnClickListener {
            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("data", binding.editTxt.text.toString())
            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        memo = binding.editTxt.text.toString()
        binding.editTxt.setText(null)
    }

    override fun onRestart() {
        super.onRestart()
        DialogClick()
    }
//    override fun onResume() {
        //super.onResume()
        // memo가 null이 아니라면
        //if (memo != null)
          //  binding.editTxt.setText(memo)
//    }

    private fun DialogClick() {

        var builder = AlertDialog.Builder(this)
        builder.setTitle("이어서 작성하시겠습니까?")
        builder.setIcon(R.mipmap.ic_launcher)
        // 버튼 클릭시에 무슨 작업을 할 것인가!
        var listener = DialogInterface.OnClickListener { p0, p1 ->
            when (p1) {
                DialogInterface.BUTTON_POSITIVE ->
                    binding.editTxt.setText(memo)
                DialogInterface.BUTTON_NEGATIVE -> {
                    binding.editTxt.setText(null)
                }
            }
        }

        builder.setPositiveButton("네", listener)
        builder.setNegativeButton("아니요", listener)
        builder.show()
    }


}