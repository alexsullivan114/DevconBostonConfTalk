package com.raywenderlich.android.reactiveexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_todo_list_item.view.*

interface TodoToggledCallback {
  fun todoToggled(todo: Todo)
}

class TodoAdapter(private val callback: TodoToggledCallback): ListAdapter<Todo, CharacterViewHolder>(TodoDiffUtil()) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_todo_list_item, parent, false)
    return CharacterViewHolder(view)
  }

  override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
    val todo = getItem(position)
    holder.itemView.todo_text.text = todo.text
    holder.itemView.todo_switch.isChecked = todo.isDone
    holder.itemView.todo_switch.setOnCheckedChangeListener { _, isChecked ->
      callback.todoToggled(todo)
    }
  }
}

class CharacterViewHolder(view: View): RecyclerView.ViewHolder(view)

class TodoDiffUtil: DiffUtil.ItemCallback<Todo>() {
  override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
    return oldItem.text == newItem.text
  }

  override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
    return oldItem == newItem
  }
}
