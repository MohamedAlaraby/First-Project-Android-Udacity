package com.udacity.shoestore.fragments.listFragment
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.ActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.shoe_layout_item.view.*
class ShoeListFragment : Fragment() {
    private lateinit var  binding:FragmentShoeListBinding
    private lateinit var activityViewModel: ActivityViewModel

    lateinit var  list:LiveData<MutableList<Shoe>>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
         ): View?
    {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        //Define the view model with view model factory
        activityViewModel= ViewModelProvider(requireActivity()).get(ActivityViewModel::class.java)

        //Observing on the shoes
        activityViewModel.shoeList.observe(viewLifecycleOwner, Observer { list->
            for (index in 0 until activityViewModel.shoeList.value!!.size)
            {
                val myLayout: LinearLayout? = activity?.findViewById(R.id.shoe_list_frag)
                val ll = layoutInflater.inflate(R.layout.shoe_layout_item, null, false)
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                ll.layoutParams = params
                ll.tv_shoeName.text=list[index].name
                ll.tv_shoeSize.text=list[index].size.toString()
                ll.tv_shoeComp.text=list[index].company
                ll.tv_shoe_desc.text=list[index].description
                myLayout?.addView(ll)
            }
        })


        binding.fabShoeDetials.setOnClickListener {view:View ->
          view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        }
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController())
                ||super.onOptionsItemSelected(item)
    }


}