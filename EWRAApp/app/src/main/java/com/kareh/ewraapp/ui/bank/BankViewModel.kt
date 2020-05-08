package com.kareh.ewraapp.ui.bank

import androidx.lifecycle.ViewModel
import com.kareh.ewraapp.R
import com.kareh.ewraapp.models.BankItem

class BankViewModel : ViewModel() {

    fun loadDetailsToList(): MutableList<BankItem> {
        val details: MutableList<BankItem> = mutableListOf()
        details.add(BankItem(R.drawable.bank_card, "Withdraw"))
        details.add(BankItem(R.drawable.balance, "Check Balance"))
        details.add(BankItem(R.drawable.transfer, "Transfer Money"))
        return details
    }

}