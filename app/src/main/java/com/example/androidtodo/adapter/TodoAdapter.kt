package com.example.androidtodo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtodo.R
import com.example.androidtodo.model.Todo

class TodoAdapter(
    private val context: Context, private val dataset: List<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    class TodoViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val todoView: View = findViewById(R.id.todo_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.todo_item, parent)
        return TodoViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.todoItem.text = dataset[position].todo
        holder.itemView.todoCheckbox.isChecked = dataset[position].isComplete
    }

    override fun getItemCount(): Int = dataset.size
}