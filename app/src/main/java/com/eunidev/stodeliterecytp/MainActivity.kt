package com.eunidev.stodeliterecytp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eunidev.stodeliterecytp.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = ArrayList<Content>()
        list.add(Content(Random.nextInt(), "Title 1", "Description 1"))
        list.add(Content(Random.nextInt(), "Title 2", "Description 2"))
        list.add(Content(Random.nextInt(), "Title 3", "Description 3"))
        list.add(Content(Random.nextInt(), "Title 4", "Description 4"))
        list.add(Content(Random.nextInt(), "Title 5", "Description 5"))

        adapter = RVAdapter(this, list)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        swipeRecycler(binding.recyclerView)
    }

    fun swipeRecycler(recyclerView: RecyclerView) {
        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                // Remove Item
                val pos = viewHolder.adapterPosition
                adapter.deleteItem(pos)
            }
        }

        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
}