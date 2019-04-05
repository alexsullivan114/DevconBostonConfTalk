package com.raywenderlich.android.reactiveexample

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CompletedTodoListViewModel(private val view: TodoListView): ViewModel() {
  private val repo = TodoServiceImpl()
  private val disposables = CompositeDisposable()
  private var todos = mutableListOf<Todo>()

  fun start() {
    repo.fetchTodos()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map { todos -> todos.filter { it.isDone } }
        .subscribe { todos ->
          this.todos = todos.toMutableList()
          view.setListItems(todos)
        }
        .addTo(disposables)
  }

  fun todoToggled(todo: Todo) {
    repo.saveUpdatedTodo(todo.copy(isDone = true))
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe {
          this.todos.remove(todo)
          view.setListItems(todos.toMutableList())
        }
        .addTo(disposables)
  }

  fun todoUpdated(updatedTodo: Todo) {
    if (!todos.any { it.text == updatedTodo.text }) {
      todos.add(updatedTodo)
      view.setListItems(todos.toMutableList())
    }
  }

  override fun onCleared() {
    disposables.dispose()
  }
}
