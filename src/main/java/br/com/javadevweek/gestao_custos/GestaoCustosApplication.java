package br.com.javadevweek.gestao_custos;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


// 02:34:48
@EnableCaching
@SpringBootApplication
public class GestaoCustosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoCustosApplication.class, args);
	}
}
