package br.com.javadevweek.gestao_custos;

// 40:19
import org.springframework.web.bind.annotation.RequestMapping;
// 42:48
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;


// 40:19 - @RestController
@RequestMapping("/javadevweek")
// 42:48
@RestController
public class PrimeiraController {
    
    //43:00
    @GetMapping("/helloworld")
    public String helloWorld() {

        return "Olá mundo - Primeira aula Java Dev Week :))";

    }
}
