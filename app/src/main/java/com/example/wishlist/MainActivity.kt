package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var listView: ListView
    private val itemList = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        listView = findViewById(R.id.listView)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList)
        listView.adapter = adapter
    }

    fun addToWishlist(view: View) {
        val itemText = editText.text.toString()
        if (itemText.isNotEmpty()) {
            itemList.add(itemText)
            adapter.notifyDataSetChanged()
            editText.text.clear()
        }
    }
}
