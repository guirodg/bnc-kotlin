package br.com.kotlin.banco.model

import javax.persistence.*

@Entity
data class Cliente(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var nome: String,
    var endereco: String,
)