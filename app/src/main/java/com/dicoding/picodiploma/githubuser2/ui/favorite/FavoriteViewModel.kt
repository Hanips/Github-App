package com.dicoding.picodiploma.githubuser2.ui.favorite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.dicoding.picodiploma.githubuser2.datasource.local.FavoriteDatabase
import com.dicoding.picodiploma.githubuser2.datasource.local.FavoriteUser
import com.dicoding.picodiploma.githubuser2.datasource.local.FavoriteUserDao

class FavoriteViewModel(application: Application) : AndroidViewModel(application) {
    private var userDao: FavoriteUserDao?
    private var userDb: FavoriteDatabase?

    init {
        userDb = FavoriteDatabase.getDatabase(application)
        userDao = userDb?.favoriteUserDao()
    }

    fun getFavoriteUser(): LiveData<List<FavoriteUser>>? {
        return userDao?.getFavoriteUser()
    }
}