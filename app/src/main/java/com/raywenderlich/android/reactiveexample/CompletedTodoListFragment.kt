package com.raywenderlich.android.reactiveexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_characters_list.view.*

class CompletedTodoListFragment: Fragment(), TodoListView, TodoToggledCallback {
  private val adapter = TodoAdapter(this)
  private lateinit var viewModel: CompletedTodoListViewModel

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = inflater.inflate(R.layout.fragment_characters_list, container, false)
    view.list.adapter = adapter
    view.list.layoutManager = LinearLayoutManager(view.context)
    return view
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel = buildViewModel {
      CompletedTodoListViewModel(this)
    }
  }

  override fun onStart() {
    super.onStart()
    viewModel.start()
  }

  override fun todoToggled(todo: Todo) {
    viewModel.todoToggled(todo)
  }

  override fun setListItems(todos: List<Todo>) {
    adapter.submitList(todos)
  }
}
