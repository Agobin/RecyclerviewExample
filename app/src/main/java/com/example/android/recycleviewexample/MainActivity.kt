package com.example.android.recycleviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL


        //Setting the layout manager of the recycler view
        recyclerview.layoutManager = layoutManager

        val items = Arrays.asList(resources.getStringArray(R.array.android_versions)).toList()
        val items2 = listOf<String>("Item1", "Item2", "Item3", "Item4", "Item5", "Item6","Item7","Item8", "Item9", "Item10", "Item11", "Item12", "Item13")
        val adapter = RecyclerAdapter(this, items2)

        recyclerview.adapter = adapter


    }
}
