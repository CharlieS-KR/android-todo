package com.example.androidtodo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtodo.adapter.TodoAdapter
import com.example.androidtodo.model.Todo

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var todoRecyclerView: RecyclerView
    lateinit var addButton: Button
//    lateinit var checkBox: CheckBox

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
        addButton.setOnClickListener{
            addToTodos()
            hideKeyboard()
        }

//        checkBox = findViewById<CheckBox>(R.id.todoCheckbox)
//        checkBox.setOnClickListener{view: View -> println(view)}
    }

    private fun addToTodos() {
        myTodos.add(Todo(editText.text.toString(), false))
        editText.setText("")
        todoRecyclerView.adapter!!.notifyItemInserted(myTodos.size - 1)
    }

    private fun hideKeyboard() {
        val currentFocus = this.currentFocus
        if (currentFocus != null) {
            val hideMe = getSystemService( Context.INPUT_METHOD_SERVICE ) as InputMethodManager
            hideMe.hideSoftInputFromWindow(currentFocus.windowToken, 0)
        } else {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        }
    }

//    private fun updateTodo(index: Int, completitionStatus: Boolean) { myTodos[index].isComplete = completitionStatus }
}