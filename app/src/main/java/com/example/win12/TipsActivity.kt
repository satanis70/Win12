package com.example.win12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.win12.model.Tabletennistip
import com.example.win12.model.Tennismarket
import com.example.win12.recyclers.MarketsAdapter
import com.example.win12.recyclers.TipsAdapter
import com.example.win12.repository.TipsRepository
import com.example.win12.service.Api
import com.example.win12.viewmodel.TipsViewModel
import com.example.win12.viewmodel.TipsViewModelFactory

class TipsActivity : AppCompatActivity() {

    private lateinit var tipsViewModel: TipsViewModel
    val tipsList = ArrayList<Tabletennistip>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips)

        val retrofit = RetrofitInstance.getInstance().create(Api::class.java)
        val tipsRepository = TipsRepository(retrofit)

        tipsViewModel = ViewModelProvider(this, TipsViewModelFactory(tipsRepository))[TipsViewModel::class.java]
        tipsViewModel.tips.observe(this){
            for (i in it.tabletennistips){
                tipsList.add(i)
            }
            val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_tips)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = TipsAdapter(tipsList)
        }
    }
}