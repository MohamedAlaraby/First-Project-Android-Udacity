package com.udacity.shoestore.fragments.listFragment


import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe


class ViewModelFactory(private val shoe: Shoe) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
              return ListViewModel(shoe) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}