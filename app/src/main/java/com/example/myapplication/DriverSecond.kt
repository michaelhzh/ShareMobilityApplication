package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.driver_second.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DriverSecond : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.driver_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.driver_back2).setOnClickListener {
            findNavController().navigate(R.id.action_driverSecond_to_SecondFragment)
        }
        val preferences = context?.getSharedPreferences("driver_info", Context.MODE_PRIVATE)
        val d_name = preferences?.getString("driver_name", "Does not exist")
        val d_from = preferences?.getString("driver_from", "Does not exist")
        val d_dest = preferences?.getString("driver_dest", "Does not exist")
        val d_time = preferences?.getString("driver_time", "Does not exist")

        driver_name_2.text = d_name
        driver_from_2.text = d_from
        driver_dest_2.text = d_dest
        driver_time_2.text = d_time
    }


}