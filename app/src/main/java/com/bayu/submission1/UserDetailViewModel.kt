package com.bayu.submission1

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserDetailViewModel : ViewModel() {
    val user = MutableLiveData<UserDetailResponse>()

    fun setUserDetail(username: String) {
        ApiClient.api
            .getDetailUsers(username)
            .enqueue(object : Callback<UserDetailResponse> {
                override fun onResponse(
                    call: Call<UserDetailResponse>,
                    response: Response<UserDetailResponse>
                ) {
                    if (response.isSuccessful) {
                        user.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<UserDetailResponse>, t: Throwable) {
                    t.message?.let { Log.d("Gagal...", it) }
                }
            })
    }

    fun getUserDetail(): LiveData<UserDetailResponse> {
        return user
    }
}