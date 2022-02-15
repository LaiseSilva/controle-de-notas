package com.senai.controle_notas

fun situacaoAluno(media: Int): String {

    if(media >= 5){
        return "Aprovado"
    }else{
        return  "Reprovado"
    }

}

//private fun calcularMedia(nota1: Int, nota2: Int): Int = (nota1 + nota2) / 2 da certo porque é só uma linha

//{nota1: Int, nota2: Int -> (nota1+nota2)/2} : arrow,

fun calcularMedia( vararg notas: Int): Int{
    var soma = 0
    for(nota in notas){
        soma = soma + nota
    }
    return soma/notas.size
}