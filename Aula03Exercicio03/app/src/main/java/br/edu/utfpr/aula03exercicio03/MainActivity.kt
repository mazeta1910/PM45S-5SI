package br.edu.utfpr.aula03exercicio03

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btRuim: Button
    private lateinit var btBom: Button
    private lateinit var btResultado: Button
    private lateinit var btIniciar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btRuim = findViewById(R.id.btRuim)
        btBom = findViewById(R.id.btBom)
        btResultado = findViewById(R.id.btResultado)
        btIniciar = findViewById(R.id.btIniciar)
    }
}