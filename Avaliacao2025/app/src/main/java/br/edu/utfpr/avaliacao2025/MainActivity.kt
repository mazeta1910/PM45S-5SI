package br.edu.utfpr.avaliacao2025

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.utfpr.avaliacao2025.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var pontosNos = 0
    var pontosEles = 0
    var vitoriasNos = 0
    var vitoriasEles = 0

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

        //Botão de Histórico
        binding.buttonHistorico.setOnClickListener {
            val intent = Intent(this, HistoricoActivity::class.java)

            intent.putExtra("VITORIAS_NOS", vitoriasNos)
            intent.putExtra("VITORIAS_ELES", vitoriasEles)

            startActivity(intent)
        }

        //Botão de Zerar Histórico
        binding.zerarHistorico.setOnClickListener {
            //Zerar histórico:
            vitoriasNos = 0
            vitoriasEles = 0

            //Zerar pontuação:
            pontosNos = 0
            pontosEles = 0

            binding.pontuacaoTime1.text = "0"
            binding.pontuacaoTime2.text = "0"

            Toast.makeText(this, "Histórico e Placar zerados!", Toast.LENGTH_SHORT).show()
        }


        //Botões de pontuação
        //Time 1
        binding.botao11pt.setOnClickListener {
            adicionarPontosNos(1)
        }

        binding.botao13pts.setOnClickListener {
            adicionarPontosNos(3)
        }

        binding.botao16pts.setOnClickListener {
            adicionarPontosNos(6)
        }

        binding.botao19pts.setOnClickListener {
            adicionarPontosNos(9)
        }

        binding.botao112pts.setOnClickListener {
            adicionarPontosNos(12)
        }
        //Time 2
        binding.botao21pt.setOnClickListener {
            adicionarPontosEles(1)
        }

        binding.botao23pts.setOnClickListener {
            adicionarPontosEles(3)
        }

        binding.botao26pts.setOnClickListener {
            adicionarPontosEles(6)
        }

        binding.botao29pts.setOnClickListener {
            adicionarPontosEles(9)
        }

        binding.botao212pts.setOnClickListener {
            adicionarPontosEles(12)
        }


    }

    private fun adicionarPontosNos(pontosSoma: Int) {
        pontosNos += pontosSoma

        if (pontosNos >= 12) {
            vitoriasNos += 1

            pontosNos = 0
            pontosEles = 0

            binding.pontuacaoTime2.text = "0"

            Toast.makeText(this, "A equipe Nós venceu a partida!", Toast.LENGTH_SHORT).show()
        }
        // 3. Independentemente de ter ganho ou não, atualiza a tela do "Nós"
        // convertendo a variável 'pontosNos' (Int) para String
        binding.pontuacaoTime1.text = pontosNos.toString()
    }

    private fun adicionarPontosEles(pontosSoma: Int) {
        pontosEles += pontosSoma
        if (pontosEles >= 12) {
            vitoriasEles += 1

            pontosNos = 0
            pontosEles = 0

            binding.pontuacaoTime1.text = "0"
            Toast.makeText(this, "A equipe eles venceu a partida!", Toast.LENGTH_SHORT).show()
        }
        binding.pontuacaoTime2.text = pontosEles.toString()
    }
}