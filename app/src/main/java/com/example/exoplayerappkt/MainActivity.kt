package com.example.exoplayerappkt

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.exoplayerappkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.btVideoUrl1.setOnClickListener {
            var url = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"
            goToPlayer(url)
        }

        binding.btVideoUrl2.setOnClickListener {
            var url = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"
            goToPlayer(url)
        }

        binding.btAudioUrl.setOnClickListener {
            var audioUrl = "https://github.com/rafaelreis-hotmart/Audio-Sample-files/raw/master/sample.mp3"
            goToPlayer(audioUrl)
        }
    }

    fun goToPlayer(url:String){
        var intent = Intent(this,PlayerActivity::class.java)
        intent.putExtra("url",url)
        startActivity(intent)
    }
}