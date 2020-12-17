package com.exampler.spacexdata.utils

import android.graphics.drawable.Animatable2
import android.graphics.drawable.Drawable
import android.os.Build
import android.widget.ImageView
import androidx.annotation.RequiresApi

class MyAnimate {
    @RequiresApi(Build.VERSION_CODES.M)
    fun animate(view: ImageView) {
        val image = (view.background as Animatable2)
        image.registerAnimationCallback(object : Animatable2.AnimationCallback() {
            override fun onAnimationEnd(drawable: Drawable?) {
                image.start()
            }
        })
        image.start()
    }

}