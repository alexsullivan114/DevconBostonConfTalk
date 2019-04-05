package com.raywenderlich.android.reactiveexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_todo_list_item.view.*

class TodoAdapter: RecyclerView.Adapter<CharacterViewHolder>() {
  var list: List<Todo> = emptyList()
    set(value) {
      field = value
      notifyDataSetChanged()
    }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_todo_list_item, parent, false)
    return CharacterViewHolder(view)
  }

  override fun getItemCount(): Int {
    return list.size
  }

  override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
    val todo = list[position]
    holder.itemView.todo_text.text = todo.text
    holder.itemView.todo_switch.isChecked = todo.isDone
  }
}

class CharacterViewHolder(view: View): RecyclerView.ViewHolder(view)