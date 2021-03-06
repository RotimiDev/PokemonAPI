package com.olamachia.pokemonweekseventask.ui.activities.adapters

import android.content.Context
import android.content.res.ColorStateList
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.olamachia.pokemonweekseventask.`interface`.IItemClickListener
import com.olamachia.pokemonweekseventask.R

class PokemonTypeAdapter(private var context: Context, private var typeList: List<com.olamachia.pokemonweekseventask.Model.Type>) :
    RecyclerView.Adapter<PokemonTypeAdapter.MyViewHolder>() {

    // create a viewHolder class for your recycler view item
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var chip: Chip = itemView.findViewById(R.id.type_chip) as Chip
        private var iItemClickListener: IItemClickListener? = null

        init {
            chip.setOnClickListener { view -> iItemClickListener?.onClick(view, adapterPosition) }
        }
    }

    // inflate the layout to be used by each item on the recycler view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.chip_items, parent, false)
        return MyViewHolder(view)
    }

    // returns the size of the typeList
    override fun getItemCount(): Int {
        return typeList.size
    }

    // binds the data and displays it in the specified location
    // specify the position where each property should be displayed
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.chip.text = typeList[position].type.name

        // set the chip background color
        holder.chip.chipBackgroundColor = when (position) {
            0 -> ColorStateList.valueOf(ContextCompat.getColor(this.context, R.color.fire))
            1 -> ColorStateList.valueOf(ContextCompat.getColor(this.context, R.color.poison))
            else -> ColorStateList.valueOf(ContextCompat.getColor(this.context, R.color.grass))
        }
    }
}