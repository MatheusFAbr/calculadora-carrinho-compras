package com.matheus.calculadoracarrinho.domain

import java.text.NumberFormat
import java.util.Locale

fun formatarMoeda(valor: Double): String {
    val formato = NumberFormat.getCurrencyInstance(
        Locale.forLanguageTag("pt-BR")
    )

    return formato.format(valor)
}

fun calcularSubtotal(
    itens: List<ItemCarrinho>
): Double {
    return itens.sumOf { it.calcularSubtotal() }
}

fun calcularDescontos(
    itens: List<ItemCarrinho>
): Double {
    return itens.sumOf { it.calcularDesconto() }
}

fun calcularTotalCarrinho(
    itens: List<ItemCarrinho>
): Double {
    return itens.sumOf { it.calcularTotal() }
}

fun gerarRelatorio(
    itens: List<ItemCarrinho>
): String {
    return itens
        .filter { it.produto.desconto > 0 }
        .sortedByDescending { it.calcularTotal() }
        .map {
            "${it.produto.nome}: " +
                    formatarMoeda(it.calcularTotal())
        }
        .joinToString("\n")
}
