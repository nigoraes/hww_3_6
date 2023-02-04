package com.example.hww_3_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hww_3_6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //привязка SongFragment
        supportFragmentManager.beginTransaction().add(R.id.container, SongFragment()).commit()
        //привязка PlaylistFragment
        supportFragmentManager.beginTransaction().add(R.id.container_second, PlaylistFragment()).commit()

    }
}