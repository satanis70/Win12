package com.example.win12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.models.SlideModel
import com.example.win12.model.Tennismarket
import com.example.win12.recyclers.MarketsAdapter
import com.example.win12.repository.MarketsRepository
import com.example.win12.service.Api
import com.example.win12.viewmodel.MarketsViewModel
import com.example.win12.viewmodel.MarketsViewModelFactory

class MarketsActivity : AppCompatActivity() {

    private lateinit var marketsViewModel: MarketsViewModel
    val marketsList = ArrayList<Tennismarket>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_markets)

        val retrofit = RetrofitInstance.getInstance().create(Api::class.java)
        val topMarketsRepository = MarketsRepository(retrofit)

        marketsViewModel = ViewModelProvider(this, MarketsViewModelFactory(topMarketsRepository))[MarketsViewModel::class.java]
        marketsViewModel.markets.observe(this){
            for (i in it.tennismarkets){
                marketsList.add(i)
            }
            val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_markets)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = MarketsAdapter(marketsList)
            Log.i("marketsList", marketsList.toString())
        }
    }
}