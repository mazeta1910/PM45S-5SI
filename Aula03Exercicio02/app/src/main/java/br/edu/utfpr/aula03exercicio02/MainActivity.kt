package br.edu.utfpr.aula03exercicio02

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etQtdGasolina: EditText
    private lateinit var etProporcao: EditText
    private lateinit var btConsultar: Button
    private lateinit var btCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etQtdGasolina = findViewById(R.id.etQtdGasolina)
        etProporcao = findViewById(R.id.etProporcao)
        btConsultar = findViewById(R.id.btConsultar)
        btCalcular = findViewById(R.id.btCalcular)
    }
}