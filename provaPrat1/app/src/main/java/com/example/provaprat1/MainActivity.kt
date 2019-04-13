package com.example.provaprat1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_calc.setOnClickListener{
            btCalcular()
        }

    }

    fun btCalcular(){

        val precoGasosa = edit_gaso.text.toString()
        val precoEtanol = edit_etanol.text.toString()

        if (validaCampos(precoGasosa, precoEtanol)){
            calcResultado(precoGasosa, precoEtanol)
        } else{
            text_resultado.setText("Informe preços reais!!")
        }
    }

    fun validaCampos(precoGasosa: String, precoEtanol: String): Boolean{

        if(precoGasosa.equals("") || precoEtanol.equals("")){
            return false
        }

        return true
    }

    fun calcResultado(precoGasosa: String, precoEtanol: String){

        val valorGas = precoGasosa.toDouble()
        val valorAlcool = precoEtanol.toDouble()

        val resultado = valorAlcool / valorGas

        if(resultado >= 0.7 ){
            text_resultado.setText("É melhor usar gasolina")
        } else {
            text_resultado.setText("É melhor usar Etanol")
        }

    }


}
