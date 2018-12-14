package com.foxo.gamemate.gameMate

import com.badlogic.gdx.Preferences

interface PlayServices {
    fun prefs(): Preferences
    fun initPreferences()
    fun isSignedIn(): Boolean
    fun signIn()
    fun signOut()
    fun signInSilently()
    fun submitScore(leaderboardId: String, highScore: Long)
    fun showLeaderboard(leaderboardId: String)
    fun removeAds()
    fun install()
}