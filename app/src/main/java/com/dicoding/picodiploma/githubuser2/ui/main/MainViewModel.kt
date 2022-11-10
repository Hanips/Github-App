package com.dicoding.picodiploma.githubuser2.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.githubuser2.datasource.model.User
import com.dicoding.picodiploma.githubuser2.datasource.model.UserSearch
import com.dicoding.picodiploma.githubuser2.network.Config
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val listUsers = MutableLiveData<ArrayList<User>>()

    fun setSearchUsers(query: String) {
        Config.apiInstance
            .getSearchUsers(query)
            .enqueue(object : Callback<UserSearch> {
                override fun onResponse(
                    call: Call<UserSearch>,
                    response: Response<UserSearch>
                ) {
                    if (response.isSuccessful) {
                        listUsers.postValue(response.body()?.items)
                    }
                }

                override fun onFailure(call: Call<UserSearch>, t: Throwable) {
                    Log.e(TAG, "Failure: ${t.message.toString()}")
                }

            })
    }

    fun getSearchUsers(): LiveData<ArrayList<User>> {
        return listUsers
    }

    companion object {
        private const val TAG = "MainViewModel"
    }
}