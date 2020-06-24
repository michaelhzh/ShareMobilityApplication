package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.rider_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RiderFirst : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.rider_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.rider_back).setOnClickListener {
            findNavController().navigate(R.id.action_RiderFirst_to_FirstFragment)
        }

        view.findViewById<Button>(R.id.confirmation_button_R).setOnClickListener {
            val preferences = context?.getSharedPreferences("rider_info", Context.MODE_PRIVATE)
            preferences?.edit()?.apply{
                putString("rider_name", rider_name.text.toString())
                putString("rider_from", rider_from.text.toString())
                putString("rider_dest", rider_destination.text.toString())
            }?.apply()
            findNavController().navigate(R.id.action_riderFirst_to_osmMapActivity)
        }

    }
}

