package br.com.kotlin.banco.dto

import java.time.LocalDateTime

data class ErroDto(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String?,
    val path: String
)