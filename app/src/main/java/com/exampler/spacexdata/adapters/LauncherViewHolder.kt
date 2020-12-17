package com.exampler.spacexdata.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.exampler.spacexdata.R

class LauncherViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {


    var missionName: TextView = itemView.findViewById(R.id.card_tv_missionTitle)
    var date: TextView = itemView.findViewById(R.id.card_tv_date)
    var rocketName: TextView = itemView.findViewById(R.id.card_rocket)
    var imageView: ImageView = itemView.findViewById(R.id.card_image)
    var layout: ConstraintLayout =  itemView.findViewById(R.id.card_layout)

}