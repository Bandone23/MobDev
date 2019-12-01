package com.example.mobdevdogs.ui.interfaces

import androidx.appcompat.widget.SearchView

interface NavBarrConfigurationInterface {
    fun feedToolBar(title: String, uri: String)
    fun parkingToolBar(title: String)
    fun settingsToolBar(title: String)
    fun announcementsToolBar(title: String)
    fun membersToolBar(title: String)
    fun participantsToolBar(title: String)
    fun setctionsMaterialsToolBar(title: String)
    fun searchSetOnQueryTextListener(listener: SearchView.OnQueryTextListener)
    fun setupSearchView(maxValue: Int, queryHint: Int, hintColor: Int)
    fun participantProfileToolbar(title: String)
    fun proceduresToolbar(title: String)
    fun scheduleToolbar(title: String)
}