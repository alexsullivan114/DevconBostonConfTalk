package com.raywenderlich.android.reactiveexample

import io.reactivex.Completable
import io.reactivex.Single
import java.util.*

class TodoServiceImpl : TodoService {
  override fun fetchTodos(): Single<List<Todo>> {
    val todos = listOf(
        Todo("Figure out what reactive programming is", Date(), false),
        Todo("Panic", Date(), false),
        Todo("Ask myself why I would ever choose to engage in public speaking", Date(), false),
        Todo("Pretend deadlines don't exist", Date(), false),
        Todo("Oh my god I really need to write this talk", Date(), false),
        Todo("Figure out how slides work", Date(), false),
        Todo("Figure out if there's a way I can do this without knowing how slides work", Date(), false),
        Todo("Panic again", Date(), true),
        Todo("Start writing some slides", Date(), true),
        Todo("Panic one last time", Date(), true),
        Todo("Get excited about reactive programming", Date(), true),
        Todo("Try and get other people excited about reactive programming", Date(), true)
    )

    return Single.just(todos)
  }

  override fun saveUpdatedTodo(todo: Todo): Completable {
    return Completable.complete()
  }
}
