package br.com.kotlin.banco.service

import br.com.kotlin.banco.dto.ClienteRequest
import br.com.kotlin.banco.dto.ClienteResponse
import br.com.kotlin.banco.mapper.MapperCliente
import br.com.kotlin.banco.repository.ClienteRepository
import javassist.NotFoundException
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ClienteService(
    private val repository: ClienteRepository,
    private val mapperCliente: MapperCliente,
) {

    fun listar(): List<ClienteResponse> {
        val cliente = repository.findAll()
        return cliente.stream().map { c -> mapperCliente.modelToResponse(c) }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): ClienteResponse {
        val cliente = repository.findById(id).orElseThrow { NotFoundException("Cliente não encontrado") }
        return mapperCliente.modelToResponse(cliente)
    }

    fun cadastrar(clienteRequest: ClienteRequest): ClienteResponse {
        val cliente = mapperCliente.requestToModel(clienteRequest)
        repository.save(cliente)
        return mapperCliente.modelToResponse(cliente)
    }

    fun atualizar(clienteRequest: ClienteRequest): ClienteResponse {
        val cliente = repository.findById(clienteRequest.id).orElseThrow { NotFoundException("Cliente não encontrado") }
        cliente.nome = clienteRequest.nome
        cliente.endereco = clienteRequest.endereco
        repository.save(cliente)
        return mapperCliente.modelToResponse(cliente)
    }

    fun deletar(id: Long) {
        repository.findById(id).orElseThrow() { NotFoundException("Cliente não encontrado") }
        repository.deleteById(id)
    }
}
