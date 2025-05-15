package com.andresespinoza.appmvm.data.repository

import com.andresespinoza.appmvm.data.model.QuoteModel
import com.andresespinoza.appmvm.data.model.QuoteProvider
import com.andresespinoza.appmvm.data.network.QuoteService

class QuoteRepository  {

        private val api = QuoteService()

        suspend fun getAllQuotes():List<QuoteModel>{
            val response = api.getQuotes()
            QuoteProvider.quotes = response
            return response
        }
    }