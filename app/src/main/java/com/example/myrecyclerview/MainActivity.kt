package com.example.myrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myrecyclerview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todoList = mutableListOf(
            Todo("follow AndroidDevs", false),
            Todo("learn about RecycleView", true),
            Todo("Feed my cat", true),
            Todo("Ask my Crush out", false),
            Todo("Take a shower", true)
        )
        val adapter = TodoAdapter(todoList)
        binding.rvTodos.adapter = adapter

        binding.btnAddTodo.setOnClickListener {
            val title = binding.etTodo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
        }
    }
}