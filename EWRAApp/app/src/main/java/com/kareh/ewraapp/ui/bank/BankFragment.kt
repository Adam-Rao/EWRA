package com.kareh.ewraapp.ui.bank

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kareh.ewraapp.R
import com.kareh.ewraapp.models.BankItem
import com.kareh.ewraapp.ui.adapter.BankFragmentAdapter

class BankFragment : Fragment() {

    private lateinit var bankViewModel: BankViewModel
    private lateinit var items: MutableList<BankItem>
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        bankViewModel =
                ViewModelProviders.of(this).get(BankViewModel::class.java)

        items = bankViewModel.loadDetailsToList()

        val root = inflater.inflate(R.layout.fragment_bank, container, false)
        recyclerView = root.findViewById(R.id.rv_bankFragment)
        val adapter = BankFragmentAdapter(items)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(root.context)
        return root
    }
}
