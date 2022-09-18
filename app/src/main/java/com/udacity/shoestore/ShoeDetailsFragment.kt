package com.udacity.shoestore

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
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailsFragment : Fragment() {
  lateinit var shoe:Shoe
  private lateinit var binding:FragmentShoeDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_details, container, false)


        binding.btnCancel.setOnClickListener {view->
            val action:NavDirections=ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment(shoe)
            view.findNavController().navigate( action)
        }
//        listViewModel.shoeList.value!!.add(Shoe(
//            binding.etShoeName.text.toString(),binding.etShoeSize.text.toString(),binding.etShoeCompany.text.toString(),binding.etShoeDesc.text.toString()
//        ))

        binding.btnSave.setOnClickListener {view->
            findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment(
                Shoe(
                     binding.etShoeName.text.toString()
                    ,binding.etShoeSize.text.toString()
                    ,binding.etShoeCompany.text.toString()
                    ,binding.etShoeDesc.text.toString()
                )
            ))

        }

        return binding.root
    }


}