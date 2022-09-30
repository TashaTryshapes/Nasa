package com.pradeep.asteroidneo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pradeep.asteroidneo.R
import com.pradeep.asteroidneo.model.DateModel

class AdapterNasa : RecyclerView.Adapter<AdapterNasa.Holder>() {
    private var commentsList: ArrayList<DateModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listComments: List<DateModel>) {
        commentsList.addAll(listComments)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val viewRes = LayoutInflater.from(parent.context).inflate(R.layout.item_nasa, parent, false)
        return Holder(viewRes)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.neo_reference_id.text = commentsList[position].neo_reference_id
        holder.name.text = commentsList[position].name
        holder.kilometers_estimated_diameter_min.text = "Kilometers Min:- ${commentsList[position].estimated_diameter.kilometers.estimated_diameter_min}"
        holder.kilometers_estimated_diameter_max.text =  "Kilometers Max:- ${commentsList[position].estimated_diameter.kilometers.estimated_diameter_max}"
        holder.meters_estimated_diameter_max.text =  "Meters Max:- ${commentsList[position].estimated_diameter.meters.estimated_diameter_max}"
        holder.meters_estimated_diameter_min.text =  "Meters Min:- ${commentsList[position].estimated_diameter.meters.estimated_diameter_min}"
        holder.miles_estimated_diameter_min.text =  "Meters Min:- ${commentsList[position].estimated_diameter.miles.estimated_diameter_min}"
        holder.miles_estimated_diameter_max.text =  "Meters Mix:- ${commentsList[position].estimated_diameter.miles.estimated_diameter_max}"
        holder.feet_estimated_diameter_min.text =  "Meters Min:- ${commentsList[position].estimated_diameter.feet.estimated_diameter_min}"
        holder.feet_estimated_diameter_max.text =  "Meters Mix:- ${commentsList[position].estimated_diameter.feet.estimated_diameter_max}"
        holder.close_approach_date.text= "Close Approach Date:- ${commentsList[position].close_approach_data[0].close_approach_date}"
        holder.close_approach_date_full.text= "Close Approach Date:- ${commentsList[position].close_approach_data[0].close_approach_date_full}"
        holder.epoch_date_close_approach.text= "Close Approach Date:- ${commentsList[position].close_approach_data[0].epoch_date_close_approach}"
        holder.kilometers_per_second.text= "Close Approach Date:- ${commentsList[position].close_approach_data[0].relative_velocity.kilometers_per_second}"
        holder.kilometers_per_hour.text= "Close Approach Date:- ${commentsList[position].close_approach_data[0].relative_velocity.kilometers_per_hour}"
        holder.miles_per_hour.text= "Close Approach Date:- ${commentsList[position].close_approach_data[0].relative_velocity.miles_per_hour}"
    }

    override fun getItemCount(): Int {
      return commentsList.size
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val neo_reference_id = view.findViewById<TextView>(R.id.neo_reference_id)
        val name = view.findViewById<TextView>(R.id.name)
        val kilometers_estimated_diameter_min = view.findViewById<TextView>(R.id.kilometers_estimated_diameter_min)
        val kilometers_estimated_diameter_max = view.findViewById<TextView>(R.id.kilometers_estimated_diameter_max)
        val meters_estimated_diameter_min = view.findViewById<TextView>(R.id.meters_estimated_diameter_min)
        val meters_estimated_diameter_max = view.findViewById<TextView>(R.id.meters_estimated_diameter_max)
        val miles_estimated_diameter_min = view.findViewById<TextView>(R.id.miles_estimated_diameter_min)
        val miles_estimated_diameter_max = view.findViewById<TextView>(R.id.miles_estimated_diameter_max)
        val feet_estimated_diameter_min = view.findViewById<TextView>(R.id.feet_estimated_diameter_min)
        val feet_estimated_diameter_max = view.findViewById<TextView>(R.id.feet_estimated_diameter_max)
        val close_approach_date = view.findViewById<TextView>(R.id.close_approach_date)
        val close_approach_date_full = view.findViewById<TextView>(R.id.close_approach_date_full)
        val epoch_date_close_approach = view.findViewById<TextView>(R.id.epoch_date_close_approach)
        val kilometers_per_second = view.findViewById<TextView>(R.id.kilometers_per_second)
        val kilometers_per_hour = view.findViewById<TextView>(R.id.kilometers_per_hour)
        val miles_per_hour = view.findViewById<TextView>(R.id.miles_per_hour)

    }
}