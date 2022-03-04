package com.example.appclima

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Ciudades : AppCompatActivity() {

    val TAG = "com.vidamrr.appclima.ciudades.CIUDAD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        val bMexico = findViewById<Button>(R.id.bMexico)
        val bBerlin = findViewById<Button>(R.id.bBerlin)
        val bChetumal = findViewById<Button>(R.id.bChetumal)
        val bCancun = findViewById<Button>(R.id.bCancun)
        val bTulum = findViewById<Button>(R.id.bTulum)
        val bBacalar = findViewById<Button>(R.id.bBacalar)

        bMexico.setOnClickListener(View.OnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG, "3530597") //3530597
            startActivity(intent)
        })
        bBerlin.setOnClickListener(View.OnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG, "ciudadBerlin") //2950159
            startActivity(intent)
        })
        bChetumal.setOnClickListener(View.OnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG, "ciudad-Chetumal") //3531023
            startActivity(intent)
        })
        bCancun.setOnClickListener(View.OnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG, "ciudad-Cancun") //3531673
            startActivity(intent)
        })
        bTulum.setOnClickListener(View.OnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG, "ciudad-Tulum") //3515040
            startActivity(intent)
        })
        bBacalar.setOnClickListener(View.OnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG, "ciudad-Bacalar") //3532465
            startActivity(intent)
        })
    }
}