package com.pradeep.asteroidneo.ViewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.pradeep.asteroidneo.adapter.AdapterNasa
import com.pradeep.asteroidneo.ktorRepository.GetRepository
import com.pradeep.asteroidneo.model.DateModel
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject

@SuppressLint("StaticFieldLeak")
class MainViewModel : ViewModel() {

    private val getRepository: GetRepository = GetRepository()

    var adapterNasa: AdapterNasa = AdapterNasa()
    var data = MutableLiveData<String>()

    fun getNasaList(startingDate: String, endDate: String) {

        viewModelScope.launch {
            data.value = getRepository.getComment(startingDate, endDate)
            val obj = JSONObject(data.value!!)
            if (obj.has("near_earth_objects")) {
                val neo: JSONObject = obj.getJSONObject("near_earth_objects")
                val it: Iterator<String> = neo.keys()
                while (it.hasNext()) {
                    val key: String = it.next()
                    if (neo.get(key) is JSONArray) {
                        val dateArray: JSONArray = neo.getJSONArray(key)
                        val dateDataList: ArrayList<DateModel> = ArrayList()

                        for (i in 0 until dateArray.length()) {
                            val jsonObject = dateArray.getJSONObject(i)
                            val d = Gson().fromJson(jsonObject.toString(), DateModel::class.java)

                            dateDataList.add(d)
                        }
                        adapterNasa.setData(dateDataList)
                        Log.e("TAG", "Date List : ${dateDataList.size}")
                    }
                }
            }
        }

    }
}