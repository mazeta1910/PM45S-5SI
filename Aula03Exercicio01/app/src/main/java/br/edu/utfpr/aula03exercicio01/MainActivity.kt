package br.edu.utfpr.aula03exercicio01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etCodigo: EditText
    private lateinit var etCidade: EditText
    private lateinit var etQuantidade: EditText
    private lateinit var btPesquisar: Button
    private lateinit var btIncluir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etCodigo = findViewById(R.id.etCodigo)
        etCidade = findViewById(R.id.etCidade)
        etQuantidade = findViewById(R.id.etQuantidade)
        btPesquisar = findViewById(R.id.btPesquisar)
        btIncluir = findViewById(R.id.btIncluir)
    }
}