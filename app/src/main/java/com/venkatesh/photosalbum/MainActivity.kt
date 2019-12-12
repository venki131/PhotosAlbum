package com.venkatesh.photosalbum

import android.os.Bundle
import com.venkatesh.libraries_action.Actions
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Actions.openLoginIntent(this))
    }
}
