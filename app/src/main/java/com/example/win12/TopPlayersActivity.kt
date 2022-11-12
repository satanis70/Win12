package com.example.win12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.win12.model.Topplayer
import com.example.win12.repository.TopPlayersRepository
import com.example.win12.service.Api
import com.example.win12.viewmodel.TopPlayersViewModel
import com.example.win12.viewmodel.TopPlayersViewModelFactory

class TopPlayersActivity : AppCompatActivity() {
    private lateinit var topPlayersViewModel: TopPlayersViewModel
    val list: ArrayList<Topplayer> = ArrayList()
    val imageList = ArrayList<SlideModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_players)

        val retrofit = RetrofitInstance.getInstance().create(Api::class.java)
        val topPlayersRepository = TopPlayersRepository(retrofit)

        topPlayersViewModel = ViewModelProvider(
            this, TopPlayersViewModelFactory(topPlayersRepository)
        )[TopPlayersViewModel::class.java]
        topPlayersViewModel.topPlayers.observe(this){
            for (i in it.topplayers){
                list.add(i)
                imageList.add(SlideModel(
                    i.img, "${i.name} " +
                            "\n Age: ${i.age} " +
                            "\n Country: ${i.country} " +
                            "\n Win/Loss: ${i.winloss}"
                ))
            }

            Log.i("LIST", list.toString())
            val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
            imageSlider.setImageList(imageList)

        }
    }
}