package br.com.javadevweek.gestao_custos.performance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import br.com.javadevweek.gestao_custos.entity.Despesa;
import br.com.javadevweek.gestao_custos.repository.DespesaRepository;


// 01:26:35 - Para não rodar o seeder novamente basta comentar o notation Component
//import org.springframework.stereotype.Component;
// 02:09:00
// @Component
public class GestaoDeDespesasSeeder implements CommandLineRunner {

    // 02:10:15
    @Autowired
    DespesaRepository despesaRepository;

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'run'");
        // 02:09:40
        System.out.println( "Rodando junto com a aplicaÇão");

        // 02:14:00
        List<Despesa> despesas = new ArrayList<>();
        
        // 02:15:00
        System.out.println( "Iniciando geração de seed :: " + LocalDateTime.now());

        // 02:10:40
        for( int i = 0; i <=150000; i++ ) {

            Despesa despesa = new Despesa();
            // 02:11:40
            despesa.setDescricao("Gasto nr " + i);
            // 02:13:00 - No máximo até 50
            despesa.setValor(BigDecimal.valueOf( 10 + (i % 50)));
            // 02:13:00 - No máximo 30 dias - variando entre 1 e 30
            despesa.setData(LocalDate.now().minusDays(i % 30));

            // 02:13:40 - 
            despesa.setCategoria("Teste");
            // 
            despesa.setEmail("performance@gmail.com");

            // 02:14:17
            despesas.add(despesa);

        }

        // 02:14:33
        despesaRepository.saveAll(despesas);

        // 02:15:00
        System.out.println( "Final da geração de seed :: " + LocalDateTime.now());

    }
    
}
