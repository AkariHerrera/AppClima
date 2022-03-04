package com.example.appclima

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson


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

        if (Network.hayRed(this)) {
            //ejecutar solicitud HTTP
            solicitudHTTPVolley("https://api.openweathermap.org/data/2.5/weather?id="+ciudad+"&appid=94a360f431dea169d38529c96182a045&units=metric&lang=es")
            //94a360f431dea169d38529c96182a045
            //ciudad de México 3530597
        } else {
            //mostrar mensaje de error
            Toast.makeText(this, "No hay red", Toast.LENGTH_SHORT).show()
        }
/*
        Toast.makeText(this, ciudad, Toast.LENGTH_SHORT).show()
        val ciudadmx = Ciudad("Ciudad de México", 15, "Soleado")
        val ciudadBerlin = Ciudad("Berlín", 30, "Cielo despejado")
        val ciudadChetumal = Ciudad("Chetumal", 32, "Mayormente soleado")
        val ciudadCancun = Ciudad("Cancun", 29, "Mayormente nublado")
        val ciudadTulum = Ciudad("Tulum", 35, "Soleado")
        val ciudadBacalar = Ciudad("Bacalar", 33, "Soleado")

        when (ciudad) {
            "ciudad-mexico" -> {
                tvCiudad?.text = ciudadmx.nombre
                tvGrados?.text = ciudadmx.grados.toString() + "°"
                tvEstatus?.text = ciudadmx.estatus
            }
            "ciudad-berlin" -> {
                tvCiudad?.text = ciudadBerlin.nombre
                tvGrados?.text = ciudadBerlin.grados.toString() + "°"
                tvEstatus?.text = ciudadBerlin.estatus
            }
            "ciudad-chetumal" -> {
                tvCiudad?.text = ciudadChetumal.nombre
                tvGrados?.text = ciudadChetumal.grados.toString() + "°"
                tvEstatus?.text = ciudadChetumal.estatus
            }
            "ciudad-cancun" -> {
                tvCiudad?.text = ciudadCancun.nombre
                tvGrados?.text = ciudadCancun.grados.toString() + "°"
                tvEstatus?.text = ciudadCancun.estatus
            }
            "ciudad-tulum" -> {
                tvCiudad?.text = ciudadTulum.nombre
                tvGrados?.text = ciudadTulum.grados.toString() + "°"
                tvEstatus?.text = ciudadTulum.estatus
            }
            "ciudad-bacalar" -> {
                tvCiudad?.text = ciudadBacalar.nombre
                tvGrados?.text = ciudadBacalar.grados.toString() + "°"
                tvEstatus?.text = ciudadBacalar.estatus
            }

            else -> Toast.makeText(this, "No se encuentra la información", Toast.LENGTH_SHORT)
                .show()
        }

 */
    }


        private fun solicitudHTTPVolley(url:String){
            val queue = Volley.newRequestQueue(this)

            val solicitud = StringRequest(Request.Method.GET, url, {
                 response ->
                try{
                    Log.d("solicitudHTTPVolley",response)
                    val gson = Gson()
                    val ciudad = gson.fromJson(response,Ciudad::class.java)
                    tvCiudad?.text = ciudad.name
                    tvGrados?.text = ciudad.main?.temp.toString() + "°"
                    tvEstatus?.text = ciudad.weather?.get(0)?.description
                }catch (e: Exception){

                }
            }, Response.ErrorListener{ })
            queue.add(solicitud)

    }
}