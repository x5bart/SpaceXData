package com.exampler.spacexdata.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.exampler.spacexdata.activity.TAG
import com.exampler.spacexdata.adapters.GridViewAdapter
import com.exampler.spacexdata.databinding.FragmentDetailBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private var missionName = ""
    private var date = ""
    private var rocketName = ""
    private var details = ""
    private var image = ""
    private var video = ""
    private lateinit var flickrImage: ArrayList<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        retainInstance = true
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getBungle()
        setContent()
    }

    private fun getBungle() {
        missionName = arguments!!.getString("id", "")
        date = arguments!!.getString("date", "")
        rocketName = arguments!!.getString("rocket", "")
        image = arguments!!.getString("img", "")
        details = arguments!!.getString("detail", "")
        video = arguments!!.getString("video", "")
        flickrImage = arguments!!.getStringArrayList("flickrImage") as ArrayList<String>
    }

    private fun setContent() {
        setText()
        setVideo()
        //set GridView
        binding.gridView.adapter = GridViewAdapter(this.activity!!, flickrImage)
        // set logo
        Glide.with(binding.detailImage).load(image).into(binding.detailImage)
    }

    private fun setText() {
        binding.detailTvMissionTitle.text = missionName
        binding.detailTvDate.text = date
        binding.detailRocket.text = rocketName
        binding.detailDetail.text = details
    }

    private fun setVideo() {
        video = video.substringAfter("=")
        val youTubePlayerView: YouTubePlayerView = binding.youtubePlayerView
        lifecycle.addObserver(youTubePlayerView)

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer) {
                val videoId = video
                youTubePlayer.loadVideo(videoId, 1F)
            }
        })
    }

}