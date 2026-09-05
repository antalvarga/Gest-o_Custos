package br.com.javadevweek.gestao_custos.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

// 20260819
// 01:30:27
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javadevweek.gestao_custos.entity.Despesa;

// 01:30:27
// public interface DespesaRepository {
public interface DespesaRepository extends JpaRepository< Despesa, UUID > {
    
    // 01:56:24
    List<Despesa> findByEmail( String email );
    // 01:57:10
    List<Despesa> findByEmailAndData( String email, LocalDate data );

    // 02:30:22 - Alterar DespesaRepository.java para criar
    Page<Despesa> findByEmail( String email, Pageable pageable );

}
