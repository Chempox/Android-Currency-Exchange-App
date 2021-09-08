package com.example.divisas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {
    var moneda_uno = 0.0
    var moneda_dos = 0.0
    var resultado = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cambio_uno = findViewById<Spinner>(R.id.cambio_uno)
        val cambio_dos = findViewById<Spinner>(R.id.cambio_dos)
        val btnCambiar = findViewById<Button>(R.id.btnCambiar)
        btnCambiar.setOnClickListener {convertir()}

        val lista = listOf("Peso Mexicano","Euro","Dolar","Yuan","Franco")
        val adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista)
        cambio_uno.adapter = adaptador
        cambio_dos.adapter = adaptador

        cambio_uno.onItemSelectedListener = object: OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 == 0){
                    moneda_uno = 0.050
                }
                if(p2 == 1) {
                    moneda_uno = 1.18
                }
                if(p2 == 2) {
                    moneda_uno = 1.0
                }
                if(p2 == 3) {
                    moneda_uno = 0.15
                }
                if(p2 == 4) {
                    moneda_uno = 1.09
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        cambio_dos.onItemSelectedListener = object: OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 == 0){
                    moneda_dos = 0.050
                }
                if(p2 == 1) {
                    moneda_dos = 1.18
                }
                if(p2 == 2) {
                    moneda_dos = 1.0
                }
                if(p2 == 3) {
                    moneda_dos = 0.15
                }
                if(p2 == 4) {
                    moneda_dos = 1.09
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }

    private fun convertir() {
        val resultado_cambio = findViewById<TextView>(R.id.resultado_cambio)
        val cantidadInput = findViewById<EditText>(R.id.cantidadInput)

        if(cantidadInput.text.toString() == "")
        {
            resultado_cambio.text = "Ingrese un valor"
        }
        else{

            resultado = moneda_uno/moneda_dos
            resultado = resultado*cantidadInput.text.toString().toFloat()
            resultado_cambio.text = resultado.toString()


            if(moneda_uno == moneda_dos){
                resultado = 1.00*cantidadInput.text.toString().toFloat()
                resultado_cambio.text = resultado.toString()
            }

        }

    }
}