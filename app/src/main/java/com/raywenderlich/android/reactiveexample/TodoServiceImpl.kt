package com.raywenderlich.android.reactiveexample

import io.reactivex.Completable
import io.reactivex.Single
import java.util.*

class TodoServiceImpl : TodoService {
  override fun fetchTodos(): Single<List<Todo>> {
    val todos = listOf(
        Todo("Write a conference talk!", Date(), false),
        Todo("Write a conference talk1!", Date(), false),
        Todo("Write a conference talk2!", Date(), false),
        Todo("Write a conference talk3!", Date(), false),
        Todo("Write a conference talk4!", Date(), false),
        Todo("Write a conference talk5!", Date(), false),
        Todo("Write a conference talk6!", Date(), false),
        Todo("Write a conference talk7!", Date(), false),
        Todo("Write a conference talk8!", Date(), false),
        Todo("Write a conference talk9!", Date(), false),
        Todo("Write a conference talk10!", Date(), false),
        Todo("Write a conference talk11!", Date(), false)
    )

    return Single.just(todos)
  }

  override fun saveUpdatedTodo(todo: Todo): Completable {
    return Completable.complete()
  }
}
