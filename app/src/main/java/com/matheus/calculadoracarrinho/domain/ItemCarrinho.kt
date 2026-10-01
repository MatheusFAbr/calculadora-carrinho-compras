package com.matheus.calculadoracarrinho.domain

data class ItemCarrinho(
    val produto: Produto,
    val quantidade: Int
) : Pagavel {

    override fun calcularTotal(): Double {
        return produto.calcularTotal() * quantidade
    }

    fun calcularSubtotal(): Double {
        return produto.preco * quantidade
    }

    fun calcularDesconto(): Double {
        return calcularSubtotal() - calcularTotal()
    }
}
