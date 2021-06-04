package br.com.kotlin.banco.mapper

import br.com.kotlin.banco.dto.ClienteRequest
import br.com.kotlin.banco.dto.ClienteResponse
import br.com.kotlin.banco.model.Cliente
import org.springframework.stereotype.Component

@Component
class MapperCliente {
    fun requestToModel(request: ClienteRequest): Cliente {
        return Cliente(
            nome = request.nome,
            endereco = request.endereco
        )
    }

    fun modelToResponse(model: Cliente): ClienteResponse {
        return ClienteResponse(
            id = model.id,
            nome = model.nome,
            endereco = model.endereco
        )
    }
}