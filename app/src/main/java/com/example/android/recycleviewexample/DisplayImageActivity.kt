package com.example.android.recycleviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_display_image.*

class DisplayImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_image)

        val imageId = intent.getIntExtra("imageId", 0)

        if (Cache.imageId != 0) {
            imageLargeDisplay.setImageResource(Cache.imageId)
        }
        else{
            Toast.makeText(this, "Image cannot be set", Toast.LENGTH_SHORT).show()
        }

        Log.i("Agobin", "Image id is: $imageId. And Cache id is: ${Cache.imageId}")

        Cache.imageId = 0
    }
}
