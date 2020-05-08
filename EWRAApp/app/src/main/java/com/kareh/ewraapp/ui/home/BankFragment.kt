package com.kareh.ewraapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kareh.ewraapp.R

class BankFragment : Fragment() {

    private lateinit var bankViewModel: BankViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        bankViewModel =
                ViewModelProviders.of(this).get(BankViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_bank, container, false)
        return root
    }
}
