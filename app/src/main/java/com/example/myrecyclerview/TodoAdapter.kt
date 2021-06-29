package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecyclerview.databinding.ItemTodoBinding


class TodoAdapter(var todos: List<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    inner class TodoViewHolder(val item: ItemTodoBinding) : RecyclerView.ViewHolder(item.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.item.apply {
            tvTitle.text = todos[position].title
            cbDone.isChecked = false
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}