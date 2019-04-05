package com.raywenderlich.android.reactiveexample

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

interface TodoListView {
  fun setListItems(todos: List<Todo>)
}

class TodoListViewModel(private val view: TodoListView): ViewModel() {
  private val repo = TodoServiceImpl()
  private val disposables = CompositeDisposable()
  fun start() {
    repo.fetchTodos()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe { todos ->
          view.setListItems(todos)
        }
        .addTo(disposables)
  }

  fun todoCompleted(todo: Todo) {
    repo.saveUpdatedTodo(todo.copy(isDone = true))
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe()
        .addTo(disposables)
  }

  override fun onCleared() {
    disposables.dispose()
  }
}