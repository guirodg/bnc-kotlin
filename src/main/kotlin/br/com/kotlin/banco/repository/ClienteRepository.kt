package br.com.kotlin.banco.repository

import br.com.kotlin.banco.model.Cliente
import org.springframework.data.jpa.repository.JpaRepository

interface ClienteRepository : JpaRepository<Cliente, Long>