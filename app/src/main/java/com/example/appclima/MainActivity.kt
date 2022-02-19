package com.example.appclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var tvCiudad:TextView? =null
    var tvGrados:TextView? = null
    var tvEstatus:TextView? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCiudad = findViewById(R.id.tvCiudad)
        tvGrados = findViewById(R.id.tvGrados)
        tvEstatus = findViewById(R.id.tvEstatus)

        val ciudad = intent.getStringExtra("com.vidamrr.appclima.ciudades.CIUDAD")

        Toast.makeText(this,ciudad,Toast.LENGTH_SHORT).show()
        val ciudadmx=Ciudad("Ciudad de México", 15,"Soleado")
        val ciudadBerlin = Ciudad("Berlín",30,"Cielo despejado")

        if(ciudad == "ciudad-mexico"){
            //mostrar info ciudadmx
            tvCiudad?.text=ciudadmx.nombre
            tvGrados?.text = ciudadmx.grados.toString()+"°"
            tvEstatus?.text = ciudadmx.estatus
        }else if(ciudad== "ciudad-berlin"){
            //mostrar info berlin
            tvCiudad?.text=ciudadBerlin.nombre
            tvGrados?.text = ciudadBerlin.grados.toString()+"°"
            tvEstatus?.text = ciudadBerlin.estatus
        }else{
            Toast.makeText(this,"No se encuentra la información",Toast.LENGTH_SHORT).show()
        }
    }
}