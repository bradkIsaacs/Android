package com.vogella.android.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class SettingsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_settings, container, false)

        val firstName = v.findViewById<View>(R.id.firstName) as EditText
        val lastName = v.findViewById<View>(R.id.lastName) as EditText
        val submit = v.findViewById<View>(R.id.submitFL) as Button
        submit.setOnClickListener {
            //Store values as strings
            val first = firstName.text.toString()
            val last = lastName.text.toString()
            //Save Strings in bundle to be recieved later
            val bundle = Bundle()
            bundle.putString("FirstName", first)
            bundle.putString("LastName", last)
            //Transition to next fragment
            val manager = activity!!.supportFragmentManager
            val transaction = manager.beginTransaction()
            val displayFragment = DisplayFragment()
            displayFragment.arguments = bundle
            transaction.replace(R.id.fragment_container, displayFragment)
            transaction.commit()
        }
        // Inflate the layout for this fragment
        return v
    }
}
