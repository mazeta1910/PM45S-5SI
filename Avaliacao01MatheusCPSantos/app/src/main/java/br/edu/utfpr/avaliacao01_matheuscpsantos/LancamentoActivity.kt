package br.edu.utfpr.avaliacao01_matheuscpsantos

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.utfpr.avaliacao01_matheuscpsantos.databinding.ActivityLancamentoBinding

class LancamentoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLancamentoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLancamentoBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Botao de Lançar
        binding.botaoLancar2.setOnClickListener {
            val tipo = if (binding.rbDebito.isChecked) "pagar" else "receber"
            val valorStr = binding.qtdValor.text.toString()
            val valor = valorStr.toDoubleOrNull() ?: 0.0

            if (tipo == "pagar") {
                ContadorGlobal.contasPagar += valor
            } else {
                ContadorGlobal.contasReceber += valor
            }
            Toast.makeText(this, getString(R.string.lancamento_sucesso), Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

object ContadorGlobal {
    var contasPagar: Double = 0.0
    var contasReceber: Double = 0.0
}