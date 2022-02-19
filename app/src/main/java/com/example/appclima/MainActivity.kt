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
        val ciudadChetumal = Ciudad("Chetumal",32,"Mayormente soleado")
        val ciudadCancun = Ciudad("Cancun",29,"Mayormente nublado")
        val ciudadTulum = Ciudad("Tulum",35,"Soleado")
        val ciudadBacalar = Ciudad("Bacalar",33,"Soleado")

        when(ciudad){
            "ciudad-mexico" -> {tvCiudad?.text=ciudadmx.nombre
                tvGrados?.text=ciudadmx.grados.toString()+"°"
                tvEstatus?.text=ciudadmx.estatus}
            "ciudad-berlin" -> {
                tvCiudad?.text=ciudadBerlin.nombre
                tvGrados?.text=ciudadBerlin.grados.toString()+"°"
                tvEstatus?.text=ciudadBerlin.estatus}
            "ciudad-chetumal" -> {
                tvCiudad?.text=ciudadChetumal.nombre
                tvGrados?.text=ciudadChetumal.grados.toString()+"°"
                tvEstatus?.text=ciudadChetumal.estatus}
            "ciudad-cancun" -> {
                tvCiudad?.text=ciudadCancun.nombre
                tvGrados?.text=ciudadCancun.grados.toString()+"°"
                tvEstatus?.text=ciudadCancun.estatus}
            "ciudad-tulum" -> {
                tvCiudad?.text=ciudadTulum.nombre
                tvGrados?.text=ciudadTulum.grados.toString()+"°"
                tvEstatus?.text=ciudadTulum.estatus}
            "ciudad-bacalar" -> {
                tvCiudad?.text=ciudadBacalar.nombre
                tvGrados?.text=ciudadBacalar.grados.toString()+"°"
                tvEstatus?.text=ciudadBacalar.estatus}

            else -> Toast.makeText(this,"No se encuentra la información", Toast.LENGTH_SHORT).show()
        }
    }
}