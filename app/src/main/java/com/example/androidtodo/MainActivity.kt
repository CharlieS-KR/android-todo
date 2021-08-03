package com.example.androidtodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtodo.adapter.TodoAdapter
import com.example.androidtodo.model.Todo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myTodos: List<Todo> = listOf(
            Todo("eat dinner", false)
        )
        val todoRecyclerView: RecyclerView = findViewById(R.id.todo_recycler_view)
        todoRecyclerView.adapter = TodoAdapter(this, myTodos)
        todoRecyclerView.setHasFixedSize(true)
    }
}