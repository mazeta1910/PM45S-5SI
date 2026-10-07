package br.edu.utfpr.avaliacao2025

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.utfpr.avaliacao2025.databinding.ActivityHistoricoBinding
import br.edu.utfpr.avaliacao2025.databinding.ActivityMainBinding

class HistoricoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoricoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoricoBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        val vitoriasNos = intent.getIntExtra("VITORIAS_NOS", 0)
        val vitoriasEles = intent.getIntExtra("VITORIAS_ELES", 0)
        binding.placarNos.text = vitoriasNos.toString()
        binding.placarEles.text = vitoriasEles.toString()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }
}