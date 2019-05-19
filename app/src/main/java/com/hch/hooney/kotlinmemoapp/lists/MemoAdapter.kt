package com.hch.hooney.kotlinmemoapp.lists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hch.hooney.kotlinmemoapp.R
import com.hch.hooney.kotlinmemoapp.vo.MemoData
import kotlinx.android.synthetic.main.item_memo.view.*

class MemoAdapter(memolist:MutableList<MemoData>,
                  private val onItemViewClickListener:(memoData:MemoData)->Unit) : RecyclerView.Adapter<MemoAdapter.MemoHolder>() {
    var list : MutableList<MemoData> = memolist
    lateinit var buttonListener:OnItemButtonClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_memo, parent, false)
        val memoHolder = MemoHolder(view)
        view.setOnClickListener{
            onItemViewClickListener.invoke(list[memoHolder.adapterPosition])
        }
        return memoHolder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MemoHolder, position: Int) {
        val item:MemoData = this.list[((list.size-1)-(position))]
        holder.mButton.setOnClickListener {
            if(this.buttonListener != null ){
                this.buttonListener.onClick(holder.mButton, item)
            }
        }
    }


    interface OnItemButtonClickListener{
        fun onClick(view: View, data:MemoData)
    }

    fun setOnItemViewClickListener(listener:OnItemButtonClickListener){
        this.buttonListener = listener
    }

    class MemoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mTitle : TextView = itemView.findViewById(R.id.item_memo_title)
        var mContent : TextView = itemView.findViewById(R.id.item_memo_content)
        var mModify : TextView = itemView.findViewById(R.id.item_memo_modify)
        var mCreate : TextView = itemView.findViewById(R.id.item_memo_create)
        var mButton : Button = itemView.findViewById(R.id.item_memo_test_btn)
    }
}