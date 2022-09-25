package com.udacity.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.ActivityViewModel
import com.udacity.shoestore.models.Shoe


class ShoeDetailsFragment : Fragment() {
    private lateinit var binding:FragmentShoeDetailsBinding
    private lateinit var activityViewModel: ActivityViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        binding.btnCancel.setOnClickListener { view->
            val action:NavDirections=ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment()
            view.findNavController().navigate(action)
        }
        binding.btnSave.setOnClickListener {view->
          val  shoe=Shoe(
                 binding.etShoeName.text.toString()
                ,binding.etShoeSize.text.toString().toDouble()
                ,binding.etShoeCompany.text.toString()
                ,binding.etShoeDesc.text.toString()
            )

            activityViewModel = ViewModelProvider(requireActivity()).get(ActivityViewModel::class.java)
            activityViewModel.addShoeToList(shoe)
            view.findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
        }

        return binding.root
    }


}