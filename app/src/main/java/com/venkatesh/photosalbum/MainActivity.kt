package com.venkatesh.photosalbum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.venkatesh.libraries_action.Actions

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Actions.openLoginIntent(this))
    }
}
