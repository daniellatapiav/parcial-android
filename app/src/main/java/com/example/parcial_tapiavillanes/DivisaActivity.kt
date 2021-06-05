package com.example.parcial_tapiavillanes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DivisaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_divisa)

        val montoARetirar = intent.getIntExtra("monto", 0)

        val tvMontoFinal:TextView = findViewById(R.id.tvMontoFinal)
        val rvDivisas:RecyclerView = findViewById(R.id.rvDivisas)
        val btnFinalizar:Button = findViewById(R.id.btnFinalizar)

        rvDivisas.adapter = DivisaAdapter(listDivisas())
        rvDivisas.layoutManager = LinearLayoutManager(this)

        tvMontoFinal.text = montoARetirar.toString()

        btnFinalizar.setOnClickListener {
            Toast.makeText(this, "Su solicitud fue exitosa", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun listDivisas():List<Divisa> {
        val lstDivisas:ArrayList<Divisa> = ArrayList()

        lstDivisas.add(Divisa(1, R.drawable.peru, "Soles", "PEN", "Perú"))
        lstDivisas.add(Divisa(2, R.drawable.eeuu, "Dólares americanos", "USD", "Estados Unidos"))
        lstDivisas.add(Divisa(3, R.drawable.ue, "Euros", "EUR", "Unión Europea"))
        lstDivisas.add(Divisa(4, R.drawable.china, "Yuan", "CNY", "China"))
        lstDivisas.add(Divisa(5, R.drawable.rusia, "Rublo ruso", "RUB", "Rusia"))
        lstDivisas.add(Divisa(6, R.drawable.bitcoin, "Bitcoin", "BTC", "World"))

        return lstDivisas
    }
}