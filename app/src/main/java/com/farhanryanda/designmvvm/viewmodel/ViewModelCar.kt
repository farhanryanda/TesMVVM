package com.farhanryanda.designmvvm.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.farhanryanda.designpattern.model.ResponseCarItem
import com.farhanryanda.designpattern.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelCar: ViewModel() {
    var liveDataListCar : MutableLiveData<List<ResponseCarItem>> = MutableLiveData()

    fun getLiveDataCar(): MutableLiveData<List<ResponseCarItem>> {
        return liveDataListCar
    }

    fun callApiCar() {
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<ResponseCarItem>> {
                override fun onResponse(
                    call: Call<List<ResponseCarItem>>,
                    response: Response<List<ResponseCarItem>>
                ) {
                    if (response.isSuccessful) {
                        liveDataListCar.postValue(response.body())
                    } else {
                        liveDataListCar.postValue(null!!)
                    }
                }

                override fun onFailure(call: Call<List<ResponseCarItem>>, t: Throwable) {
                    Log.e("TAG", "onFailure: ${t.message} ", )
                }

            })
    }
}