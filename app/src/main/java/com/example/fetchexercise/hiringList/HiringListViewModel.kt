package com.example.fetchexercise.hiringList

import android.os.Build
import androidx.annotation.RequiresApi
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


    @RequiresApi(Build.VERSION_CODES.N)
    private suspend fun fetchHiring() {
        withContext(Dispatchers.IO) {
            val hiringList = Network.Hirings.getHiringlist().await()
            hiringList.removeIf { obj: NetworkHiring? -> obj?.name == null || obj.name == "" }
            hiringList.sortBy { it.listId }
            _hirings.postValue(hiringList)
        }
    }
}