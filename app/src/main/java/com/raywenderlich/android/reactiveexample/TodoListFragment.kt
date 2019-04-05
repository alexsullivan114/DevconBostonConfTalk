package com.raywenderlich.android.reactiveexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_characters_list.view.*

class TodoListFragment: Fragment(), TodoListView {
  private val adapter = TodoAdapter()
  private val viewModel = buildViewModel {
    TodoListViewModel(this)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = inflater.inflate(R.layout.fragment_characters_list, container, false)
    view.list.adapter = adapter
    view.list.layoutManager = LinearLayoutManager(view.context)
    return view
  }

  override fun onStart() {
    super.onStart()
    viewModel.start()
  }

  override fun setListItems(todos: List<Todo>) {
    adapter.list = todos
  }
}