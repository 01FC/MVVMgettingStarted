package com.fcamacho.mvvmexample.utilities

import com.fcamacho.mvvmexample.data.FakeDatabase
import com.fcamacho.mvvmexample.data.QuoteRepository
import com.fcamacho.mvvmexample.ui.quotes.QuotesViewModelFactory

object InjectorUtils {
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quotesRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quotesRepository)
    }
}