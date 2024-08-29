package com.curso.android.planetsapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyCustomAdapter(context: Context, planets: List<Planet>) :
    ArrayAdapter<Planet>(context, R.layout.item_list_layout, planets) {


    @SuppressLint("CutPasteId")
    override fun getView(position: Int,
                         convertView: View?,
                         parent: ViewGroup): View {

        var viewHolder : ViewHolder = ViewHolder()
        var view : android.view.View
        val result : android.view.View

        val planet : Planet? = getItem(position)

        if(convertView == null) {
            view = LayoutInflater.from(context)
                .inflate(R.layout.item_list_layout, parent, false)

            viewHolder.planetName = view.findViewById(R.id.planetName) as TextView
            viewHolder.moonCounter = view.findViewById(R.id.moonText) as TextView
            viewHolder.imagePlanet = view.findViewById(R.id.planetView) as ImageView

            result = view
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
            result = view
        }

        viewHolder.planetName?.text = planet?.planetName
        viewHolder.moonCounter?.text = planet?.moonCount
        viewHolder.imagePlanet?.setImageResource(planet?.planetImage!!)

        return view
    }

    class ViewHolder {
        var planetName: TextView? = null
        var moonCounter: TextView? = null
        var imagePlanet: ImageView? = null
    }
}