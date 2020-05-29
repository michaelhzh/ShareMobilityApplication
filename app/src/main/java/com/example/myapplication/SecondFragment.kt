package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.driver_first.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.driver_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.driver_back).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        view.findViewById<Button>(R.id.confirmation_button_D).setOnClickListener {
            val preferences = context?.getSharedPreferences("driver_info", Context.MODE_PRIVATE)
            preferences?.edit()?.apply{
                putString("driver_name", driver_name.text.toString())
                putString("driver_from", driver_from.text.toString())
                putString("driver_dest", driver_destination.text.toString())
                putString("driver_time", driver_time.text.toString())
            }?.apply()
            findNavController().navigate(R.id.action_SecondFragment_to_driverSecond)
        }
    }
}
