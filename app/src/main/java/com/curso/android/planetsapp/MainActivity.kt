package com.curso.android.planetsapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val planetsArrayList = ArrayList<Planet>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        planetsArrayList.add(Planet("Mercury", "0", R.drawable.mercury))
        planetsArrayList.add(Planet("Venus", "0", R.drawable.venus))
        planetsArrayList.add(Planet("Earth", "1", R.drawable.earth))
        planetsArrayList.add(Planet("Mars", "2", R.drawable.mars))
        planetsArrayList.add(Planet("Jupiter", "79", R.drawable.jupiter))
        planetsArrayList.add(Planet("Saturn", "82", R.drawable.saturn))
        planetsArrayList.add(Planet("Uranus", "27", R.drawable.uranus))
        planetsArrayList.add(Planet("Neptune", "14", R.drawable.neptune))
        planetsArrayList.add(Planet("Pluto", "5", R.drawable.pluto))

        val arrayAdapter = MyCustomAdapter(this, planetsArrayList)

        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedPlanet = planetsArrayList[position]
            Toast.makeText(this,
                "Clicked on: ${(listView.adapter.getItem(position) as Planet).planetName}, " +
                        "that have:  ${selectedPlanet.moonCount} moons",
                Toast.LENGTH_SHORT).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}