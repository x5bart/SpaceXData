package com.exampler.spacexdata.adapters

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exampler.spacexdata.fragments.DetailFragment
import com.exampler.spacexdata.R
import com.exampler.spacexdata.activity.MainActivity
import com.exampler.spacexdata.activity.TAG
import com.exampler.spacexdata.model.CurrentLauncher


class LauncherViewAdapter(private val list: ArrayList<CurrentLauncher>, private val context: Context) :
    RecyclerView.Adapter<LauncherViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LauncherViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.launches_card, parent, false)
        return LauncherViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LauncherViewHolder, position: Int) {
        val list = list[position]
        holder.apply {
            missionName.text = list.missionName
            date.text = list.date
            rocketName.text = list.rocket.rocketName
            Glide.with(imageView).load(list.links.image).into(imageView)
        }
        holder.layout.setOnClickListener {
            val fragment = DetailFragment()
            val bundle = Bundle()
            bundle.putString("id", list.missionName)
            bundle.putString("date", list.date)
            bundle.putString("rocket", list.rocket.rocketName)
            bundle.putString("img", list.links.image)
            bundle.putString("detail", list.details)
            bundle.putString("video", list.links.video)
            bundle.putStringArrayList("flickrImage",list.links.flickrImage)

            fragment.arguments = bundle
            val fragmentManager =
                (context as MainActivity).supportFragmentManager.beginTransaction()
            fragmentManager.addToBackStack("list")
            fragmentManager.replace(R.id.fragment_container, fragment)
            fragmentManager.commit()

        }
    }


}