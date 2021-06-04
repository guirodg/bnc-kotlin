package br.com.kotlin.banco.dto

data class ClienteRequest(
    val id: Long,
    val nome: String,
    val endereco: String
)
