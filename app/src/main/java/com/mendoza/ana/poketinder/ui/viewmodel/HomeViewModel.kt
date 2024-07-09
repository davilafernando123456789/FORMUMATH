package com.mendoza.ana.poketinder.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mendoza.ana.poketinder.ui.model.Subject
import com.mendoza.ana.poketinder.ui.model.Topic

import java.io.InputStreamReader

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val _subjectList = MutableLiveData<List<Subject>>()
    val subjectList: LiveData<List<Subject>> get() = _subjectList

    private val _filteredSubjectList = MutableLiveData<List<Subject>>()
    val filteredSubjectList: LiveData<List<Subject>> get() = _filteredSubjectList

    private val _favoriteList = MutableLiveData<List<Subject>>()
    val favoriteList: LiveData<List<Subject>> get() = _favoriteList

    private val _topicList = MutableLiveData<List<Topic>>()
    val topicList: LiveData<List<Topic>> get() = _topicList

    init {
        loadSubjects()
    }

    private fun loadSubjects() {
        val context = getApplication<Application>().applicationContext
        val inputStream = context.assets.open("subjects.json")
        val reader = InputStreamReader(inputStream)
        val type = object : TypeToken<List<Subject>>() {}.type
        val subjects: List<Subject> = Gson().fromJson(reader, type)
        Log.d("JSON Loading", "Subjects loaded: ${subjects.size}")
        _subjectList.postValue(subjects)
    }


    fun filterSubjects(query: String) {
        if (query.isEmpty()) {
            _filteredSubjectList.postValue(_subjectList.value)
        } else {
            _filteredSubjectList.postValue(
                _subjectList.value?.filter {
                    it.title.contains(query, ignoreCase = true)
                }
            )
        }
    }

    fun loadTopicsForSubject(subject: Subject) {
        _topicList.postValue(subject.topics)
    }
}
