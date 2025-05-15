package com.andresespinoza.appmvm.domain

import com.andresespinoza.appmvm.data.repository.QuoteRepository
import com.andresespinoza.appmvm.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()
    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()
}