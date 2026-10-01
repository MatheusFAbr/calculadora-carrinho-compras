package com.matheus.calculadoracarrinho

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.matheus.calculadoracarrinho.data.carrinho
import com.matheus.calculadoracarrinho.domain.gerarRelatorio
import com.matheus.calculadoracarrinho.ui.CarrinhoScreen
import com.matheus.calculadoracarrinho.ui.theme.CalculadoraCarrinhoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(
            "RELATORIO_CARRINHO",
            "PRODUTOS COM DESCONTO:\n" +
                    gerarRelatorio(carrinho)
        )

        setContent {
            CalculadoraCarrinhoTheme {
                CarrinhoScreen(itens = carrinho)
            }
        }
    }
}
