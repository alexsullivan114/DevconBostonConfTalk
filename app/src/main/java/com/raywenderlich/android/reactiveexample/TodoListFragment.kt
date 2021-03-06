package com.raywenderlich.android.reactiveexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_characters_list.view.*

class TodoListFragment: Fragment(), TodoListView, TodoToggledCallback, TodoUpdatedCallback {
  private val adapter = TodoAdapter(this)
  private lateinit var viewModel: TodoListViewModel

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = inflater.inflate(R.layout.fragment_characters_list, container, false)
    view.list.adapter = adapter
    view.list.layoutManager = LinearLayoutManager(view.context)
    return view
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel = buildViewModel {
      TodoListViewModel(this)
    }
  }

  override fun onStart() {
    super.onStart()
    viewModel.start()
  }

  override fun todoUpdated(todo: Todo) {
    viewModel.todoUpdated(todo)
  }

  override fun todoToggled(todo: Todo) {
    viewModel.todoCompleted(todo)
    (activity as? TodoUpdatedCallback)?.todoUpdated(todo.copy(isDone = !todo.isDone))
  }

  override fun setListItems(todos: List<Todo>) {
    adapter.submitList(todos)
  }
}
