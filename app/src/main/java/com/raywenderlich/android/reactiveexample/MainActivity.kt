package com.raywenderlich.android.reactiveexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TodoUpdatedCallback {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val adapter = TodoFragmentAdapter(supportFragmentManager)
    pager.adapter = adapter
  }

  override fun todoUpdated(todo: Todo) {
    supportFragmentManager.fragments.forEach { fragment ->
      (fragment as? TodoUpdatedCallback)?.todoUpdated(todo)
    }
  }
}

interface TodoUpdatedCallback {
  fun todoUpdated(todo: Todo)
}
