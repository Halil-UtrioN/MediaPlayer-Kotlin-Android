package com.cakirhalil.playerogrenim

import android.media.session.MediaSession
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.media3.exoplayer.ExoPlayer
import com.cakirhalil.playerogrenim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Uygulam içi oluşumlar/ yapılandırmalar
    private lateinit var binding: ActivityMainBinding
    public val player = ExoPlayer.Builder(this).build()
    val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun checkPlaybackPosition(delayMs: Long): Boolean =
        handler.postDelayed(
            {
                val currentPosition = player.currentPosition
                // Update UI based on currentPosition
                checkPlaybackPosition(delayMs)
            },
            delayMs)
}