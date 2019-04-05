package com.raywenderlich.android.reactiveexample

import io.reactivex.Completable
import io.reactivex.Single

interface TodoService {
  fun fetchTodos(): Single<List<Todo>>
  fun saveUpdatedTodo(todo: Todo): Completable
}