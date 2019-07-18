package com.fcamacho.mvvmexample.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {
    val quoteList = mutableListOf<Quote>()
    val quotes = MutableLiveData<List<Quote>>() // to be able to change the value of this live data

    init {
        quotes.value = quoteList
    }

    fun addQuote(quote:Quote) {
        quoteList.add(quote)
        // update value in the list
        quotes.value = quoteList
    }

    fun getQuotes() = quotes as LiveData<List<Quote>>
}