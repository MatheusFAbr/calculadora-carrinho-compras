package com.matheus.calculadoracarrinho.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.matheus.calculadoracarrinho.domain.*

private val AzulTexto = Color(0xFF17212F)
private val CinzaTexto = Color(0xFF718096)
private val Verde = Color(0xFF267A4B)

@Composable
fun ProdutoCard(item: ItemCarrinho) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = item.produto.nome,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = AzulTexto,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                if (item.produto.desconto > 0) {
                    Surface(
                        color = Color(0xFFE4F3E9),
                        shape = RoundedCornerShape(6.dp)
                    ) {
                        Text(
                            text = "-${item.produto.desconto.toInt()}%",
                            modifier = Modifier.padding(
                                horizontal = 8.dp,
                                vertical = 4.dp
                            ),
                            style = MaterialTheme.typography.labelMedium,
                            color = Verde
                        )
                    }
                }
            }

            Text(
                text = item.produto.descricao ?: "Sem descrição",
                style = MaterialTheme.typography.bodyMedium,
                color = CinzaTexto,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            HorizontalDivider(color = Color(0xFFF0F1F3))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column {
                    Text(
                        text = "${formatarMoeda(item.produto.preco)} " +
                                "× ${item.quantidade}",
                        style = MaterialTheme.typography.bodySmall,
                        color = CinzaTexto
                    )

                    Text(
                        text = formatarMoeda(item.calcularTotal()),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = AzulTexto
                    )
                }

                if (item.produto.desconto > 0) {
                    Text(
                        text = formatarMoeda(
                            item.calcularSubtotal()
                        ),
                        style = MaterialTheme.typography.bodySmall,
                        color = CinzaTexto,
                        textDecoration = TextDecoration.LineThrough
                    )
                }
            }
        }
    }
}
