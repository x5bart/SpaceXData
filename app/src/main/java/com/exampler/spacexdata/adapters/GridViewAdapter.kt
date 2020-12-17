package com.exampler.spacexdata.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.exampler.spacexdata.R

@GlideModule
class GridViewAdapter(private val ctx: Context, private val imageUrls: ArrayList<String>) :
    ArrayAdapter<Any?>(ctx, R.layout.grid_item_layout, imageUrls as List<Any?>) {
    private val inflater: LayoutInflater = LayoutInflater.from(ctx)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.grid_item_layout, parent, false)
        }
        val imageView = convertView!!.findViewById<ImageView>(R.id.grid_image)
        Glide
            .with(ctx)
            .load(imageUrls[position])
            .into(imageView)
        return convertView
    }

}