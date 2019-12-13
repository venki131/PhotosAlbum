package com.venkatesh.featuredashboard

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.venkatesh.libraries_actionupdateUiWithUser.EXTRA_USER
import com.venkatesh.libraries_actionupdateUiWithUser.UserArgs
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : DaggerAppCompatActivity() {
    private lateinit var navigationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        navigationController = Navigation.findNavController(this, R.id.nav_host_fragment)

        val item = intent.getParcelableExtra<UserArgs>(EXTRA_USER)

        findViewById<TextView>(R.id.txtView).text = item.userName
        bottomNavigation.setOnNavigationItemSelectedListener(::tabSelected)
    }

    private fun tabSelected(tab: MenuItem): Boolean {
        when (tab.itemId) {
            R.id.action_home -> {
                findNavController(R.id.nav_host_fragment).navigate(R.id.home_screen)
            }
            R.id.action_favourite -> {
                findNavController(R.id.nav_host_fragment).navigate(R.id.favourites_screen)
            }
            R.id.action_sharing -> {
                findNavController(R.id.nav_host_fragment).navigate(R.id.sharing_screen)
            }
        }
        return false
    }
}


