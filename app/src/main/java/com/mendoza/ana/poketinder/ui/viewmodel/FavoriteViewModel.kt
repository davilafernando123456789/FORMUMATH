package com.mendoza.ana.poketinder.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mendoza.ana.poketinder.ui.model.Subject

class FavoriteViewModel(subjectsViewModel: SubjectsViewModel) : ViewModel() {
    val favoriteList: LiveData<List<Subject>> = subjectsViewModel.favorites
}
