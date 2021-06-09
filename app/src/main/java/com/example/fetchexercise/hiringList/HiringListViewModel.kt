package com.example.fetchexercise.hiringList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchexercise.network.Network
import com.example.fetchexercise.network.NetworkHiring
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HiringListViewModel : ViewModel() {

    private var _hirings = MutableLiveData<List<NetworkHiring>>()
    val hiring: LiveData<List<NetworkHiring>>
        get() = _hirings

    init {
        viewModelScope.launch {
            fetchHiring()
        }
    }


    private suspend fun fetchHiring() {
        withContext(Dispatchers.IO) {
            val hiringList = Network.Hirings.getHiringlist().await()
            _hirings.postValue(hiringList)
        }
    }
}