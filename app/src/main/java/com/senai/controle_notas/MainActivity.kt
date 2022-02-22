package com.senai.controle_notas

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private lateinit var  nota1EditText: EditText
private lateinit var nota2EditText: EditText
private lateinit var nomeEditText: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)
        val sair =  findViewById<Button>(R.id.sair)

        calcular.setOnClickListener(){
            nota1EditText = findViewById(R.id.nota1)
            nota2EditText = findViewById(R.id.nota2)
            nomeEditText = findViewById(R.id.nome)

            val nomeEditText = findViewById<EditText>(R.id.nome)
            val situacao = findViewById<TextView>(R.id.situcao)
            val resultadoTextView = findViewById<TextView>(R.id.resultado)


            val faltas = nomeEditText.text.toString()


            if(validarCampos()){
                val nota1 = nota1EditText.text.toString().toInt()
                val nota2 = nota2EditText.text.toString().toInt()
                val nome = nomeEditText.text.toString()

                val media = calcularMedia(nota1, nota2)

                val intent =  Intent(this, ResultadoActivity::class.java)
                intent.putExtra("nome",nomeEditText.text.toString())
                intent.putExtra("nota1",nota1.toString())
                intent.putExtra("nota2",nota2.toString())
                intent.putExtra("media",media.toString())
                intent.putExtra("situacao", situacaoAluno(media))

                startActivity(intent)

//                resultadoTextView.text = situacaoAluno(media)

//                if (media >=5){
//                    resultadoTextView.text = "Nome: $nome\nNota 1: $nota1 \nNota: $nota2\nMédia: $media"
//                    situacao.text ="Aprovado(a)!!"
//                    situacao.setTextColor(Color.GREEN)
//
//                }else{
//                    resultadoTextView.text = "Nota 1: $nota1\nNota 2: $nota2 \nFaltas: $faltas\nMédia: $media"
//                    situacao.text ="Reprovado(a)!!"
//                    situacao.setTextColor(Color.RED)
//                }
            }

        }

        sair.setOnClickListener(){
            finish()
        }
    }




    private fun validarCampos(): Boolean{
      var noError = true
        if(nota1EditText.text.isBlank()){
            nota1EditText.setError("Digite a nota 1")
            noError = false
        }
        if (nota2EditText.text.isBlank()){
            nota2EditText.setError("Digite a nota 2")
            noError = false
        }

        if(nomeEditText.text.isBlank()){
            nomeEditText.setError("Digite o nome do aluno")
            noError = false
        }
        return noError
    }
}