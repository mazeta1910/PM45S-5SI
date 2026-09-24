package br.edu.utfpr.aula04exercicio01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var etValorEtanol: EditText
    private lateinit var etValorGasolina: EditText
    private lateinit var etConsumoEtanol: EditText
    private lateinit var etConsumoGasolina: EditText
    private lateinit var btCalcular: Button
    private lateinit var btSair: Button
    private lateinit var tvResultadoFinal: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etValorEtanol = findViewById(R.id.etValorEtanol)
        etValorGasolina = findViewById(R.id.etValorGasolina)
        etConsumoEtanol = findViewById(R.id.etConsumoEtanol)
        etConsumoGasolina = findViewById(R.id.etConsumoGasolina)
        btCalcular = findViewById(R.id.btCalcular)
        btSair = findViewById(R.id.btSair)
        tvResultadoFinal = findViewById(R.id.tvResultadoFinal)


        // Ao clicar no botão Sair, o aplicativo deve ser finalizado (com o comando finish())
        btSair.setOnClickListener {
            finish()
        }

        //Ao clicar no botão calcular, deve-se verificar o custo efetivo de um km com gasolina (gasolina preço/consumo gasolina) e o custo efetivo de um km com álcool (álcool preço/consumo álcool), e verificar qual possui o menor valor, adicionado a resposta ao componente TextView do Resultado
        btCalcular.setOnClickListener {
            // Limpa o resultado final a cada novo clique
            tvResultadoFinal.text = ""

            // Variável para rastrear se há erros
            var temErro = false

            // Validação individual campo a campo
            if (etValorEtanol.text.toString().trim().isEmpty()) {
                etValorEtanol.error = "Preencha o valor do Etanol"
                temErro = true
            }

            if (etValorGasolina.text.toString().trim().isEmpty()) {
                etValorGasolina.error = "Preencha o valor da Gasolina"
                temErro = true
            }

            if (etConsumoEtanol.text.toString().trim().isEmpty()) {
                etConsumoEtanol.error = "Preencha o consumo do Etanol"
                temErro = true
            }

            if (etConsumoGasolina.text.toString().trim().isEmpty()) {
                etConsumoGasolina.error = "Preencha o consumo da Gasolina"
                temErro = true
            }

            // Se NÃO tiver erro, prossegue com o cálculo
            if (!temErro) {
                val valorEtanol = etValorEtanol.text.toString().toDouble()
                val valorGasolina = etValorGasolina.text.toString().toDouble()
                val consumoEtanol = etConsumoEtanol.text.toString().toDouble()
                val consumoGasolina = etConsumoGasolina.text.toString().toDouble()

                val custoEtanol = valorEtanol / consumoEtanol
                val custoGasolina = valorGasolina / consumoGasolina

                if (custoEtanol < custoGasolina) {
                    tvResultadoFinal.text = "ETANOL"
                } else if (custoGasolina < custoEtanol) {
                    tvResultadoFinal.text = "GASOLINA"
                } else {
                    tvResultadoFinal.text = "AMBOS"
                }
            }
        }

        // Clique longo no botão Calcular
        btCalcular.setOnLongClickListener {
            Toast.makeText(this, "Calcula a melhor opção de combustível baseado nos valores inseridos", Toast.LENGTH_SHORT).show()
            true // O 'true' indica que o evento de clique longo foi consumido e concluído
        }

        // Clique longo no botão Sair (você chamou a variável de btSair)
        btSair.setOnLongClickListener {
            Toast.makeText(this, "Encerra o aplicativo", Toast.LENGTH_SHORT).show()
            true // Consome o evento
        }
    }
}