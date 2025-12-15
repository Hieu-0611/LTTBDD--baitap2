package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView // Nếu muốn dùng TextView thay Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setMargins

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNumber = findViewById<EditText>(R.id.edtNumber)
        val btnCreate = findViewById<Button>(R.id.btnCreate)
        val llContainer = findViewById<LinearLayout>(R.id.llContainer)

        // 1. Tìm cái TextView báo lỗi mới thêm
        val tvError = findViewById<TextView>(R.id.tvError)

        btnCreate.setOnClickListener {
            val inputString = edtNumber.text.toString()
            val number = inputString.toIntOrNull()

            // SỬA DÒNG NÀY:
            // Thêm điều kiện: hoặc number <= 0 (số âm hoặc bằng 0 đều lỗi)
            if (number == null || number <= 0) {

                // TRƯỜNG HỢP LỖI:
                tvError.text = "Dữ liệu bạn nhập không hợp lệ"

                // Xóa danh sách cũ đi
                llContainer.removeAllViews()

            } else {
                // TRƯỜNG HỢP ĐÚNG:
                tvError.text = "" // Xóa thông báo lỗi cũ
                llContainer.removeAllViews() // Xóa nút cũ

                for (i in 1..number) {
                    val newButton = Button(this)
                    newButton.text = i.toString()
                    newButton.setBackgroundResource(R.drawable.bg_red_item) // Hoặc bg_rounded_button tùy bạn
                    newButton.setTextColor(Color.WHITE) // Nếu nền đỏ thì chữ trắng cho dễ nhìn

                    val params = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    params.setMargins(0, 0, 0, 20)
                    newButton.layoutParams = params

                    llContainer.addView(newButton)
                }
            }
        }
    }
}