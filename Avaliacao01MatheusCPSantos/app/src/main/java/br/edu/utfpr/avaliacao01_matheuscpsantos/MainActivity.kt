package br.edu.utfpr.avaliacao01_matheuscpsantos

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.utfpr.avaliacao01_matheuscpsantos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Botão de Lançar
        binding.botaoLancar.setOnClickListener{
            val intent = Intent(this, LancamentoActivity::class.java)
            startActivity(intent)
        }

        //Botão Total Pagar
        binding.botaoTotalPagar.setOnClickListener{
            Toast.makeText(this, getString(R.string.totalPagar), Toast.LENGTH_SHORT).show()
        }

        //Botão Total Receber
        binding.botaoTotalReceber.setOnClickListener {
            Toast.makeText(this, getString(R.string.totalReceber), Toast.LENGTH_SHORT).show()
        }
    }
}