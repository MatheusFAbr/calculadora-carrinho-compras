package com.matheus.calculadoracarrinho.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.matheus.calculadoracarrinho.domain.*

private val AzulEscuro = Color(0xFF233E59)
private val AzulTexto = Color(0xFF17212F)
private val CinzaTexto = Color(0xFF718096)
private val Fundo = Color(0xFFF7F8FA)

@Composable
fun CarrinhoScreen(itens: List<ItemCarrinho>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Fundo),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "MINHA COMPRA",
                        style = MaterialTheme.typography.labelMedium,
                        color = CinzaTexto
                    )

                    Text(
                        text = "Meu carrinho",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = AzulTexto
                    )

                    Text(
                        text = "${itens.sumOf { it.quantidade }} " +
                                "produtos no carrinho",
                        style = MaterialTheme.typography.bodyMedium,
                        color = CinzaTexto
                    )
                }

                Surface(
                    color = Color(0xFFE8EDF3),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text(
                        text = "🛒",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
        }

        items(itens) { item ->
            ProdutoCard(item)
        }

        item {
            Spacer(Modifier.height(6.dp))
            ResumoPedido(itens)
        }
    }
}

@Composable
private fun ResumoPedido(itens: List<ItemCarrinho>) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        color = AzulEscuro
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Text(
                text = "Resumo do pedido",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )

            LinhaResumo(
                "Subtotal",
                formatarMoeda(calcularSubtotal(itens))
            )

            LinhaResumo(
                "Descontos",
                "- ${formatarMoeda(calcularDescontos(itens))}",
                corValor = Color(0xFFA6E8C2)
            )

            HorizontalDivider(
                color = Color(0xFF587087)
            )

            LinhaResumo(
                "Total",
                formatarMoeda(calcularTotalCarrinho(itens)),
                destaque = true
            )
        }
    }
}

@Composable
private fun LinhaResumo(
    titulo: String,
    valor: String,
    corValor: Color = Color.White,
    destaque: Boolean = false
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = titulo,
            style = if (destaque)
                MaterialTheme.typography.titleMedium
            else
                MaterialTheme.typography.bodyMedium,
            color = if (destaque) Color.White
            else Color(0xFFD4DFE9)
        )

        Text(
            text = valor,
            style = if (destaque)
                MaterialTheme.typography.titleLarge
            else
                MaterialTheme.typography.bodyMedium,
            fontWeight = if (destaque)
                FontWeight.Bold
            else
                FontWeight.Normal,
            color = corValor
        )
    }
}
