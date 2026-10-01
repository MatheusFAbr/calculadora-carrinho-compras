package com.matheus.calculadoracarrinho.domain

data class Produto(
    val nome: String,
    val preco: Double,
    val descricao: String? = null,
    val desconto: Double = 0.0
) : Pagavel {

    override fun calcularTotal(): Double {
        return preco * (1 - desconto / 100)
    }
}
