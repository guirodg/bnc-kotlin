package br.com.kotlin.banco.repository

import org.springframework.data.jpa.repository.JpaRepository

interface ContaRepository : JpaRepository<Conta, Long>