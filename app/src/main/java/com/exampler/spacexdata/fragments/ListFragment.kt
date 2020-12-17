package com.exampler.spacexdata.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exampler.spacexdata.activity.TAG
import com.exampler.spacexdata.adapters.LauncherViewAdapter
import com.exampler.spacexdata.api.Api
import com.exampler.spacexdata.databinding.FragmentListBinding
import com.exampler.spacexdata.model.CurrentLauncher
import com.exampler.spacexdata.utils.MyAnimate
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var myAnimate: MyAnimate
    private var launcherViewAdapter: LauncherViewAdapter? = null
    private var models: ArrayList<CurrentLauncher> = ArrayList()
    private var recyclerView: RecyclerView? = null
    private var BASE_URL = "https://api.spacexdata.com/v3/"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, null, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.rvContainer
        recyclerView!!.layoutManager = LinearLayoutManager(this.context)
        parseJson()
        startLoader()
    }

    private fun startLoader() {
        myAnimate = MyAnimate()
        binding.loader.visibility = View.VISIBLE
        binding.logo.visibility = View.VISIBLE
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            myAnimate.animate(binding.loader)
        } else binding.loader.visibility = View.GONE
    }

    private fun parseJson() {
        val context = context!!
        val retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val request: Api = retrofit.create(Api::class.java)
        val call1: Call<List<CurrentLauncher>> = request.json
        call1.enqueue(object : Callback<List<CurrentLauncher>> {
            override fun onResponse(
                call: Call<List<CurrentLauncher>>,
                response: Response<List<CurrentLauncher>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    models = ArrayList(response.body())
                    launcherViewAdapter = LauncherViewAdapter(models, context)
                    recyclerView!!.adapter = launcherViewAdapter
                }
                binding.loader.visibility = View.GONE
                binding.logo.visibility = View.GONE
            }

            override fun onFailure(call: Call<List<CurrentLauncher>>, t: Throwable) {
                Log.d(TAG, "Parse Json onFailure")
            }

        })
    }
}
