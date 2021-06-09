package com.example.fetchexercise.hiringList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchexercise.network.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HiringListViewModel : ViewModel() {

    init {
        viewModelScope.launch {
            fetchHiring()
        }
    }


    suspend fun fetchHiring() {
        withContext(Dispatchers.IO) {
            val hiringList = Network.Hirings.getHiringlist().await()
            Log.i("HiringListViewModel", hiringList.size.toString())
        }
    }
}