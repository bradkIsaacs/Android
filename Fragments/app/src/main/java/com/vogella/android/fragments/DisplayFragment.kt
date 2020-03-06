package com.vogella.android.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle

import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class DisplayFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_display, container, false)
        val bundle = arguments
        val firstName = bundle!!.getString("FirstName")
        val lastName = bundle.getString("LastName")
        val display = v.findViewById<View>(R.id.display) as TextView
        display.text = "Welcome ${firstName} ${lastName}"
        // Inflate the layout for this fragment
        return v
    }
}
