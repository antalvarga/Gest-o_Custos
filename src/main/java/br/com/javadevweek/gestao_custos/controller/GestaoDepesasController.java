package br.com.javadevweek.gestao_custos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.javadevweek.gestao_custos.entity.Despesa;
import br.com.javadevweek.gestao_custos.useCases.BuscarDespesaUseCase;
import br.com.javadevweek.gestao_custos.useCases.CadastroDespesaUseCase;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import br.com.javadevweek.gestao_custos.custom_messages.ErrorMessage;

// 47:38
@RequestMapping("/gestao")

// 1:11:56
@RestController
public class GestaoDepesasController {


    
    /*
    
        Cadastro de despesa
        Criar tabela no b.d.
        Criar entidade
    */

    // 01:16:55
    @Autowired
    CadastroDespesaUseCase cadastroDespesaUseCase;

    // 01:58:50
    @Autowired
    BuscarDespesaUseCase buscarDespesaUseCase;

    // 47:38
    @PostMapping("/create")
    // 01:44:50
    // public Despesa create(@RequestBody Despesa despesa ){

    public ResponseEntity<?> create(@RequestBody Despesa despesa ){

        // 01:16:54
        // CadastroDespesaUseCase cadastroDespesaUseCase = new CadastroDespesaUseCase();

        // 01:44:06
        try {
            // 01:45:00
            // return cadastroDespesaUseCase.execute( despesa );
            var result = cadastroDespesaUseCase.execute( despesa );

            return ResponseEntity.ok( result );
            
        } catch (IllegalArgumentException e) {
            // 01:45:25
            // return null;
            // 01:45:30
            //return ResponseEntity.status(400).body( e.getMessage() );
            //01:47:00
            var errorMessage = new ErrorMessage( e.getMessage(), "INVALID_PARAMS");

            return ResponseEntity.status( 400 ).body( errorMessage );
        }
    }

    // 01:49:05
    // 01:50:00 - Exemplo: //gestao/find/danieleleao@gamil.com?date=2025-06-08
    //@GetMapping("/")
    // 01:50:45
    // 01:54:39 , @RequestParam
    @GetMapping("/{email}")
    // 01:58:45
    // public void findByEmailAndDate( @PathVariable String email, @RequestParam( required = false ) LocalDate data ) {
    public List<Despesa> findByEmailAndDate( @PathVariable String email, @RequestParam( required = false ) LocalDate data ) {

        // System.out.println(":: Email:: " + email );
        // System.out.println(":: Data :: " + data );

        // 01:59:10
        // 01:59:22
        return buscarDespesaUseCase.execute(email, data);


    }
    
}
