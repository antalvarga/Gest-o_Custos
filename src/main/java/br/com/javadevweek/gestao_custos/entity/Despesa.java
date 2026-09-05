package br.com.javadevweek.gestao_custos.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
// import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//
@Entity
@Table( name = "despesa")
public class Despesa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name="description", nullable = false )
    private String descricao;

    // 01:37:35
    @Column( nullable = false )
    private LocalDate data;
    
    // 01:37:35
    @Column( nullable = false )
    private BigDecimal valor;

    // 01:27:30
    // 01:37:21
    // @Column(length =100 )
    @Column(length =100, nullable = false )
    private String categoria;
    
    // 01:37:35
    @Column( nullable = false )
    private String email;

    // 1:34:45
    //@CreatedDate
    // 1:34:50
    @CreationTimestamp
    private LocalDate data_criacao;
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(LocalDate data_criacao) {
        this.data_criacao = data_criacao;
    }

    @Override
    public String toString() {
        return "Despesa [id=" + id + ", descricao=" + descricao + ", data=" + data + ", valor=" + valor + ", categoria="
                + categoria + ", email=" + email + ", data_criacao=" + data_criacao + "]";
    }

    // 1:02:15
    // clicar c botao direito> Source Action> Generate Getters and Setters
    



}
