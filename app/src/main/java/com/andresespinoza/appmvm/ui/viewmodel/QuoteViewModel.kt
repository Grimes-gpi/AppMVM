package com.andresespinoza.appmvm.ui.viewmodel
import androidx.lifecycle.viewModelScope

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.andresespinoza.appmvm.data.model.QuoteModel
import com.andresespinoza.appmvm.data.model.QuoteProvider
import com.andresespinoza.appmvm.domain.GetQuotesUseCase
import com.andresespinoza.appmvm.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {
      val quoteModel = MutableLiveData<QuoteModel>()
    val getQuotesUseCase = GetQuotesUseCase()
    val isLoading = MutableLiveData<Boolean>()







    fun onCreate() {
        viewModelScope.launch {
            val result:List<QuoteModel>? = getQuotesUseCase()

            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
            }
        }
    }
    fun randomQuote(){
        var getRandomQuoteUseCase = GetRandomQuoteUseCase()

        fun randomQuote() {
            isLoading.postValue(true)

            viewModelScope.launch {
                val quote = getRandomQuoteUseCase()
                if (quote != null) {
                    quoteModel.postValue(quote)
                }
                isLoading.postValue(false)
            }
        }

        //val currentQuote = QuoteProvider.random()

    }

}
