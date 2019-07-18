package com.fcamacho.mvvmexample.ui.quotes

import androidx.lifecycle.ViewModel
import com.fcamacho.mvvmexample.data.Quote
import com.fcamacho.mvvmexample.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {
    fun getQuotes() = quoteRepository.getQuotes()
    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}