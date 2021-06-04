package br.com.kotlin.banco.dto

data class ClienteResponse(
    val id: Long?,
    val nome: String,
    val endereco: String
)