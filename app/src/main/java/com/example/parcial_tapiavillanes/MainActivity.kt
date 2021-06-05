package com.example.parcial_tapiavillanes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spnTipoDocumento: Spinner = findViewById(R.id.spnTipoDoc)
        val etNumeroDocumento: EditText = findViewById(R.id.etNumDoc)
        val rgGenero: RadioGroup = findViewById(R.id.rgGenero)
        val btnConsultar: Button = findViewById(R.id.btnConsultar)

        ArrayAdapter.createFromResource(
            this,
            R.array.tipos_documento,
            android.R.layout.simple_spinner_item
        ).also{
                adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spnTipoDocumento.adapter = adapter
        }

        var spnTipoDocumentoValue = ""

        spnTipoDocumento.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                spnTipoDocumentoValue = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        btnConsultar.setOnClickListener {
            var numeroDocumento:String = etNumeroDocumento.text.toString()
            var flag = false

            if(numeroDocumento.substring(7) != "7" && numeroDocumento.substring(7) != "8" && numeroDocumento.substring(7) != "9") {
                Toast.makeText(this, "Usted no cumple con las condiciones", Toast.LENGTH_LONG).show()
                numeroDocumento = ""
            } else {
                flag = true
            }

            if(flag) {
                val intent = Intent(this, SolicitudActivity::class.java)
                startActivity(intent)
            }
        }
    }
}