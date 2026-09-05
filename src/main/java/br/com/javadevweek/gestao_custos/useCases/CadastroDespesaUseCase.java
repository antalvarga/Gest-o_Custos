package br.com.javadevweek.gestao_custos.useCases;


import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javadevweek.gestao_custos.entity.Despesa;
import br.com.javadevweek.gestao_custos.repository.DespesaRepository;

// 01:18:24
@Service
public class CadastroDespesaUseCase {

    // 01:31:37
    @Autowired
    private DespesaRepository despesaRepository;
    
    
    public Despesa execute( Despesa despesa ){

        // 01:19:30
        /*        
        System.out.println( "Categoria: " + despesa.getCategoria() );
        System.out.println( "E-mail: " + despesa.getEmail() );
        System.out.println( "Valor: " + despesa.getValor() );
        System.out.println( "Despesa:: " + despesa );
        */
        
        // 01:41:00 - testes de validação
        if( despesa.getCategoria() == null || despesa.getData() == null || despesa.getEmail() == null ) {

            // 01:42:50
            throw new IllegalArgumentException( "Preencher todos os campos ");

        }



        /// *** Na video aula, a Daniele não sugere isso 
        /// O objeto despesa Ficou sublinhado com a mensagem 
        /// Null type safety: The expression of type 'Despesa' needs unchecked conversion to conform to '@NonNull Despesa'Java(16778128)
        /// Despesa despesa - br.com.javadevweek.gestao_custos.useCases.CadastroDespesaUseCase.execute(Despesa)
        /// Source: gestao-custos
        /// Usei o gemini 
        /// https://gemini.google.com/app/b50449fb7cd7572f
        /// 
        Objects.requireNonNull(despesa, "A despesa não pode ser nula");

        /*        
        // 1:33:00
        System.out.println( "=== ANTES DE SALVAR === ");
        System.out.println( despesa );

        // 1:31:45 - 1:32:25
        despesa = despesaRepository.save( despesa );
        
        // 1:33:31
        System.out.println( "=== DEPOIS DE SALVAR === ");
        System.out.println( despesa );
        
        */
        // 1:36:00 - Retirada dos comentários
        despesa = despesaRepository.save( despesa );

        return despesa;

    }
    
}
