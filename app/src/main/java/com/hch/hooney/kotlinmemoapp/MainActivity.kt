package com.hch.hooney.kotlinmemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.hch.hooney.kotlinmemoapp.vo.MemoData

class MainActivity : AppCompatActivity() {
    lateinit var memoList : MutableList<MemoData>
    lateinit var recycler : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        //init List
        memoList = arrayListOf()
    }
}
