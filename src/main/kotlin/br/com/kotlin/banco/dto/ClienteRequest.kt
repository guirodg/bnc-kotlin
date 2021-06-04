package br.com.kotlin.banco.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class ClienteRequest(
    val id: Long,
    @field:NotBlank(message = "Não pode ser em branco") @field:Size(
        min = 5,
        max = 50,
        message = " deve ter entre 5 e 50 caracteres"
    ) val nome: String,
    @field:NotBlank(message = "Não pode ser em branco") @field:Size(
        min = 5,
        max = 50,
        message = " deve ter entre 5 e 50 caracteres"
    ) val endereco: String
)
