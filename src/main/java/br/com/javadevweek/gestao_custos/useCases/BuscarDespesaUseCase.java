package br.com.javadevweek.gestao_custos.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import br.com.javadevweek.gestao_custos.entity.Despesa;
import br.com.javadevweek.gestao_custos.repository.DespesaRepository;

// 01:53:45
// public class BuscarDespesaUseCase {
// 01:55:10
@Service
public class BuscarDespesaUseCase {

    // 01:55:49
    @Autowired
    private DespesaRepository despesaRepository;

    // 01:55:20
    // public List<Despesa> buscarPorEmailEData( String email, LocalDate data ) {
    // 01:59:15
    public List<Despesa> execute( String email, LocalDate data ) {
        // 01:56:00
        // despesaRepository.findby
        // 01:57:40
        List<Despesa> despesas;

        if( data != null ) {
            despesas = despesaRepository.findByEmailAndData(email, data);
        } else {
            despesas = despesaRepository.findByEmail(email);
        }

        return despesas;
    }
    
}
