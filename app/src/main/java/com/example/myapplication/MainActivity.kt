package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*


//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//    }
//}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.currency_spinner)
        val inputAmount = findViewById<EditText>(R.id.input_amount)
        val convertButton = findViewById<Button>(R.id.convert_button)
        val resultText = findViewById<TextView>(R.id.result_text)

        val conversionRates = mapOf(
            "USD to IDR" to 15000.0,
            "YEN to IDR" to 115.0,
            "EUR to IDR" to 17000.0,
            "IDR to USD" to 1 / 15000.0,
            "IDR to YEN" to 1 / 115.0,
            "IDR to EUR" to 1 / 17000.0
        )

        convertButton.setOnClickListener {
            val selectedCurrency = spinner.selectedItem.toString()
            val amount = inputAmount.text.toString().toDoubleOrNull()

            if (amount != null && selectedCurrency in conversionRates) {
                val result = amount * (conversionRates[selectedCurrency] ?: 1.0)
                resultText.text = "Converted amount: %.2f".format(result)
            } else {
                Toast.makeText(this, "Mohon masukkan jumlah dengan benar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}