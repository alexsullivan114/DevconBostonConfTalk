package com.raywenderlich.android.reactiveexample

import io.reactivex.Completable
import io.reactivex.Single
import java.util.*

class TodoServiceImpl : TodoService {
  override fun fetchTodos(): Single<List<Todo>> {
    val todos = listOf(
        Todo("Write a conference talk!", Date(), false),
        Todo("Write a conference talk!", Date(), false),
        Todo("Write a conference talk!", Date(), false),
        Todo("Write a conference talk!", Date(), false),
        Todo("Write a conference talk!", Date(), false),
        Todo("Write a conference talk!", Date(), false),
        Todo("Write a conference talk!", Date(), false),
        Todo("Write a conference talk!", Date(), false),
        Todo("Write a conference talk!", Date(), false),
        Todo("Write a conference talk!", Date(), false),
        Todo("Write a conference talk!", Date(), false),
        Todo("Write a conference talk!", Date(), false)
    )

    return Single.just(todos)
  }

  override fun saveUpdatedTodo(todo: Todo): Completable {
    return Completable.complete()
  }
}