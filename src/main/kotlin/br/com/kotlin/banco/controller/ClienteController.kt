package br.com.kotlin.banco.controller

import br.com.kotlin.banco.dto.ClienteRequest
import br.com.kotlin.banco.dto.ClienteResponse
import br.com.kotlin.banco.service.ClienteService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/clientes")
class ClienteController(private val service: ClienteService) {

    @GetMapping
    fun listar(): List<ClienteResponse> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ClienteResponse {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(
        @RequestBody @Valid clienteRequest: ClienteRequest,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ClienteResponse> {
        val clienteResponse = service.cadastrar(clienteRequest)
        val uri = uriBuilder.path("/clientes${clienteRequest.id}").build().toUri()
        return ResponseEntity.created(uri).body(clienteResponse)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid clienteRequest: ClienteRequest): ResponseEntity<ClienteResponse> {
        val cliente = service.atualizar(clienteRequest)
        return ResponseEntity.ok(cliente)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }


}