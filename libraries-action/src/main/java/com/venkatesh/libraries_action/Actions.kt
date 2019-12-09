package com.venkatesh.libraries_action

import android.content.Context
import android.content.Intent
import com.venkatesh.libraries_actionupdateUiWithUser.EXTRA_USER
import com.venkatesh.libraries_actionupdateUiWithUser.UserArgs

object Actions {
    fun openLoginIntent(context: Context): Intent = internalIntent(context, "com.venkatesh.login.open")
    fun openDashboardIntent(context: Context, userName: String) =
        internalIntent(context, "com.venkatesh.dashboard.open")
            .putExtra(EXTRA_USER, UserArgs(userName))

    private fun internalIntent(context: Context, action: String) = Intent(action).setPackage(context.packageName)
}