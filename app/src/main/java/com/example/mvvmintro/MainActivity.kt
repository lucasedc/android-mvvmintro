package com.example.mvvmintro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.textViewWelcome.observe(this, Observer {
            tvHello.text = it
        })

        viewModel.login.observe(this, Observer {
            if(it){
                Toast.makeText(applicationContext,"Sucesso!",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"Falha!",Toast.LENGTH_SHORT).show()
            }
        })

        btnLogin.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        var retorno = viewModel.login(etName.text.toString())
    }
}