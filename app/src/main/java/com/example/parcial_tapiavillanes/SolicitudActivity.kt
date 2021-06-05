package com.example.parcial_tapiavillanes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SolicitudActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solicitud)

        val etMonto:EditText = findViewById(R.id.etMonto)
        val btnSolicitar: Button = findViewById(R.id.btnSolicitar)

        btnSolicitar.setOnClickListener {
            var montoARetirar:Int = etMonto.text.toString().toInt()
            var flag = false

            if(montoARetirar < 100 || montoARetirar > 20000) {
                Toast.makeText(this, "El monto a retirar debe ser mayor a S/ 100 y menor o igual S/ 20,000", Toast.LENGTH_LONG).show()
                montoARetirar = 0
            } else {
                flag = true
            }

            if(flag) {
                val intent = Intent(this, DivisaActivity::class.java)
                intent.putExtra("monto", montoARetirar)
                startActivity(intent)
            }
        }
    }
}