package com.matheus.calculadoracarrinho.data

import com.matheus.calculadoracarrinho.domain.Produto
import com.matheus.calculadoracarrinho.domain.ItemCarrinho

val catalogo = listOf(
    Produto(
        nome = "Notebook Dell Inspiron",
        preco = 3499.00,
        descricao = "Notebook rápido para estudos e trabalho",
        desconto = 5.0
    ),

    Produto(
        nome = "Mouse sem fio",
        preco = 89.90,
        descricao = null
    ),

    Produto(
        nome = "Teclado mecânico RGB",
        preco = 349.90,
        descricao = "Switch azul, ABNT2"
    ),

    Produto(
        nome = "Monitor Gamer UltraWide de Alta Resolução",
        preco = 1599.90,
        descricao = "Monitor de 34 polegadas com alta taxa de atualização",
        desconto = 10.0
    ),

    Produto(
        nome = "Headset Bluetooth",
        preco = 199.90,
        descricao = "Fone com microfone e cancelamento de ruído"
    ),

    Produto(
        nome = "Webcam Full HD",
        preco = 249.90,
        descricao = "Câmera para reuniões e videochamadas"
    )
)

val carrinho = listOf(
    ItemCarrinho(
        produto = catalogo[0],
        quantidade = 2
    ),

    ItemCarrinho(
        produto = catalogo[1],
        quantidade = 1
    ),

    ItemCarrinho(
        produto = catalogo[2],
        quantidade = 1
    )
)
