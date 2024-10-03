package com.prime.media.old.impl

import androidx.lifecycle.ViewModel
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.logEvent
import com.google.firebase.ktx.Firebase
import com.prime.media.old.config.PersonalizeViewState
import com.prime.media.settings.Settings
import com.primex.preferences.Preferences


class PersonalizeViewModel(
    private val preferences: Preferences,
) : ViewModel(), PersonalizeViewState {

    override fun setInAppWidget(id: String) {
        preferences[Settings.GLANCE] = id
        Firebase.analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM){
            param(FirebaseAnalytics.Param.ITEM_ID, id)
        }
    }

}