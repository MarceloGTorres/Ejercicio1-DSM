package com.example.ejercicio1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etStudentName = findViewById<EditText>(R.id.etStudentName)
        val etNote1 = findViewById<EditText>(R.id.etNote1)
        val etNote2 = findViewById<EditText>(R.id.etNote2)
        val etNote3 = findViewById<EditText>(R.id.etNote3)
        val etNote4 = findViewById<EditText>(R.id.etNote4)
        val etNote5 = findViewById<EditText>(R.id.etNote5)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val ivResult = findViewById<ImageView>(R.id.ivResult)
        val tvMessage = findViewById<TextView>(R.id.tvMessage)

        btnCalculate.setOnClickListener {
            val name = etStudentName.text.toString()
            val note1 = etNote1.text.toString().toDoubleOrNull()
            val note2 = etNote2.text.toString().toDoubleOrNull()
            val note3 = etNote3.text.toString().toDoubleOrNull()
            val note4 = etNote4.text.toString().toDoubleOrNull()
            val note5 = etNote5.text.toString().toDoubleOrNull()

            if (note1 == null || note2 == null || note3 == null || note4 == null || note5 == null ||
                note1 < 0 || note1 > 10 ||
                note2 < 0 || note2 > 10 ||
                note3 < 0 || note3 > 10 ||
                note4 < 0 || note4 > 10 ||
                note5 < 0 || note5 > 10) {
                Toast.makeText(this, "Por favor, ingresa notas válidas entre 0 y 10", Toast.LENGTH_LONG).show()
            } else {
                val finalGrade = (note1 * 0.15) + (note2 * 0.15) + (note3 * 0.20) + (note4 * 0.25) + (note5 * 0.25)
                val result = if (finalGrade >= 5) "aprobó" else "reprobó"
                tvResult.text = "El estudiante $name $result con una nota final de ${String.format("%.2f", finalGrade)}"

                if (finalGrade >= 5) {
                    ivResult.setImageResource(R.drawable.aprobado_image)
                    tvMessage.text = "¡Felicitaciones, $name! ¡Sigue así!"
                } else {
                    ivResult.setImageResource(R.drawable.reprobado_image)
                    tvMessage.text = "No te desanimes, $name. ¡Puedes mejorar!"
                }
                ivResult.visibility = ImageView.VISIBLE
                tvMessage.visibility = TextView.VISIBLE
            }
        }
    }
}