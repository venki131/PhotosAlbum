package com.venkatesh.featuredashboard

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.venkatesh.libraries_actionupdateUiWithUser.EXTRA_USER

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val userName: String? = intent.getStringExtra(EXTRA_USER)

        findViewById<TextView>(R.id.txtView).text = userName
    }
}

