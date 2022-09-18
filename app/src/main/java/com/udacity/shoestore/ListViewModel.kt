package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe


 class ListViewModel(shoe:Shoe) :ViewModel() {
  private  var  list:MutableList<Shoe> = mutableListOf<Shoe>(
     Shoe("High-tops","40.0","NIKI","Beautiful Shoes"),
     Shoe(" Chuck Taylor","44.0","ADDIDAS","Beautiful Shoes"),
     Shoe(" Golf shoes","40.0","NIKI","Beautiful Shoes"),
     Shoe("Hiking boots","42.0","ADDIDAS","Beautiful Shoes")

 )
     private var _shoeList= MutableLiveData<MutableList<Shoe>>()
   init {

       _shoeList.value= list
       _shoeList.value!!.add(shoe)
   }
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList


 }