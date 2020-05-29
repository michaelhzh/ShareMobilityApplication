package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.rider_second.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RiderSecond : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.rider_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.rider_back2).setOnClickListener {
            findNavController().navigate(R.id.action_riderSecond_to_riderFirst)
        }

        val preferences = context?.getSharedPreferences("rider_info", Context.MODE_PRIVATE)
        val r_name = preferences?.getString("rider_name", "Does not exist")
        val r_from = preferences?.getString("rider_from", "Does not exist")
        val r_dest = preferences?.getString("rider_dest", "Does not exist")
        rider_name_2.text = r_name
        rider_from_2.text = r_from
        rider_destination_2.text = r_dest
    }

}