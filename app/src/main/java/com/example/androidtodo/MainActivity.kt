package com.example.androidtodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtodo.adapter.TodoAdapter
import com.example.androidtodo.model.Todo

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var todoRecyclerView: RecyclerView
    lateinit var addButton: Button

    private val myTodos: MutableList<Todo> = mutableListOf(
        Todo("eat dinner", false)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById<EditText>(R.id.todo_input)

        todoRecyclerView = findViewById<RecyclerView>(R.id.todo_recycler_view)
        todoRecyclerView.adapter = TodoAdapter(this, myTodos)
        todoRecyclerView.setHasFixedSize(true)

        addButton = findViewById<Button>(R.id.todo_button)
        addButton.setOnClickListener{ addToTodos() }
    }

    private fun addToTodos() {
        val currentText: String = editText.text.toString()
        myTodos.add(Todo(currentText, false))
    }
}