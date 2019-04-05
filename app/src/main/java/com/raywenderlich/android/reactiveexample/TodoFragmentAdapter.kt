package com.raywenderlich.android.reactiveexample

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TodoFragmentAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
  override fun getItem(position: Int): Fragment {
    return when (position) {
      0 -> TodoListFragment()
      else -> CompletedTodoListFragment()
    }
  }

  override fun getCount(): Int {
    return 2
  }
}
