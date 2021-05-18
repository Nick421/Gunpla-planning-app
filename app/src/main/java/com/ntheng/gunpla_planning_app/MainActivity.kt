package com.ntheng.gunpla_planning_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing the array lists and the adapter
        val itemlist = arrayListOf<String>()
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, itemlist)

        val editText = findViewById<EditText>(R.id.editText)
        val listView = findViewById<ListView>(R.id.listView)
        // Adding the items to the list when the add button is pressed
        val add = findViewById<Button>(R.id.add);
        add.setOnClickListener {
            itemlist.add(editText.text.toString())
            listView.adapter =  adapter
            adapter.notifyDataSetChanged()
            // This is because every time when you add the item the input      space or the eidt text space will be cleared
            editText.text.clear()
        }

        // Selecting and Deleting the items from the list when the delete button is pressed
        val delete = findViewById<Button>(R.id.delete)
        delete.setOnClickListener {
            val position: SparseBooleanArray = listView.checkedItemPositions
            val count = listView.count
            var item = count - 1
            while (item >= 0) {
                if (position.get(item))
                {
                    adapter.remove(itemlist.get(item))
                }
                item--
            }
            position.clear()
            adapter.notifyDataSetChanged()
        }

        // Clearing all the items in the list when the clear button is pressed
        val clear = findViewById<Button>(R.id.clear)
        clear.setOnClickListener {

            itemlist.clear()
            adapter.notifyDataSetChanged()

        }

        // Adding the toast message to the list when an item on the list is pressed
        listView.setOnItemClickListener { adapterView, view, i, l ->
            android.widget.Toast.makeText(this, "You Selected the item --> "+itemlist.get(i), android.widget.Toast.LENGTH_SHORT).show()
        }


    }
}