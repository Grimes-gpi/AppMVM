package com.andresespinoza.appmvm.domain

import com.andresespinoza.appmvm.data.model.QuoteModel
import com.andresespinoza.appmvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    operator fun invoke():QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}