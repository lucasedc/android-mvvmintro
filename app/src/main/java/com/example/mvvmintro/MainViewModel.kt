package com.example.mvvmintro

import android.text.Editable
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var repository = MainRepository()

    private var mTextViewWelcome = MutableLiveData<String>()
    var textViewWelcome = mTextViewWelcome

    init {
        mTextViewWelcome.value = "Hello"
    }

    private var mLogin = MutableLiveData<Boolean>()
    var login = mLogin

    fun login(name: String) {
        var retorno = repository.login(name)
        mLogin.value = retorno

    }


}