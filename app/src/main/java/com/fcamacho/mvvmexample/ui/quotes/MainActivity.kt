package com.fcamacho.mvvmexample.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.fcamacho.mvvmexample.R
import com.fcamacho.mvvmexample.data.Quote
import com.fcamacho.mvvmexample.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializaUi()
    }

    private fun initializaUi() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(QuotesViewModel::class.java)
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            tv_main_text.text = stringBuilder.toString()
        })

        fab_main_add_button.setOnClickListener {
            val quote = Quote(tiet_main_phrase.text.toString(), tiet_main_author.text.toString())
            viewModel.addQuote(quote)
            tiet_main_phrase.text = Editable.Factory.getInstance().newEditable("")
            tiet_main_author.text = Editable.Factory.getInstance().newEditable("")
        }
    }

}
