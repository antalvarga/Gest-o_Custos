package br.com.javadevweek.gestao_custos.performance;


import java.util.List;

//
//import org.hibernate.query.Page;
import org.springframework.data.domain.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
// Estava conflitando
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
// Ao trocar pela linha abaixo, parou de dar o erro no metodo
// despesaRepository.findAll( paggeable );
// 02:25:40
import org.springframework.data.domain.Pageable;

// Foi necessario devido a public ResponseEntity<Page<Despesa>> listarComPaginacao(@NonNull Pageable pageable)
//import io.micrometer.common.lang.NonNull;
import org.springframework.lang.NonNull;


import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.javadevweek.gestao_custos.entity.Despesa;
import br.com.javadevweek.gestao_custos.repository.DespesaRepository;



// 02:17:45
@RequestMapping("/gestao/performance")
// 02:20:56
@RestController
// 02:35:10
@EnableCaching
public class GestaoDespesasPerformance {
    
    // 02:17:55
    @Autowired
    DespesaRepository despesaRepository;

    // 02:20:16
    @GetMapping( "/sem-paginacao")
    public ResponseEntity<List<Despesa>> listarSemPaginacao() {

        
        // 02:19:20
        long inicio = System.currentTimeMillis();
        
        var despesas = despesaRepository.findAll();

        // 02:19:47
        long fim = System.currentTimeMillis();

        System.out.println( "Tempo sem paginacao: " + (fim - inicio) + " em milisegundos " );

        return ResponseEntity.ok( despesas );
    }

    // 02:23:00
    @GetMapping( "/com-paginacao") // localhost:8080?page=10&size=10    
    public ResponseEntity<Page<Despesa>> listarComPaginacao( @NonNull Pageable paggeable ) {

        // 02:25:55
        // long inicio = System.currentTimeMillis();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        
        var despesas = despesaRepository.findAll( paggeable );

        // 02:26:36
        // long fim = System.currentTimeMillis();
        stopWatch.stop();

        // 02:26:56
        System.out.println( "Tempo com paginacao: " + stopWatch.getTotalTimeMillis() + " em milisegundos " );
        System.out.println( "Tempo com paginacao: " + stopWatch.getTotalTimeSeconds() + " em segundos " );

        return ResponseEntity.ok( despesas );
    }

    @GetMapping("/com-paginacao/{email}")
    public ResponseEntity<Page<Despesa>> listarComPaginacaoAndEmail(
         @PathVariable String email
         , @NonNull Pageable pageable ) {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        var despesas = despesaRepository.findByEmail( email, pageable );
        stopWatch.stop();

        System.out.println( "Tempo com paginacao: " + stopWatch.getTotalTimeSeconds() + " em segundos " );

        return ResponseEntity.ok( despesas );
    }

    // 02:33:39
    @GetMapping("/cache/{email}")
    // 02:39:04
    @Cacheable( value = "gastosPorEmailCache", key = "#email + '-' + #pageable.pageNumber + '-' + #pageable.pageSize + '-'")
    public ResponseEntity<Page<Despesa>> cacheComPaginacao(
         @PathVariable String email
         , @NonNull Pageable pageable ) {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        var despesas = despesaRepository.findByEmail( email, pageable );
        stopWatch.stop();

        System.out.println( "Tempo com paginacao: " + stopWatch.getTotalTimeSeconds() + " em segundos " );

        return ResponseEntity.ok( despesas );
    }


}
