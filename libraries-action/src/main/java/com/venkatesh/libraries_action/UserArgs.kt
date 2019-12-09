package com.venkatesh.libraries_actionupdateUiWithUser

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

const val EXTRA_USER = "com.venkatesh.dashboard.open.extra.user"

@Parcelize
data class UserArgs(val userName: String) : Parcelable