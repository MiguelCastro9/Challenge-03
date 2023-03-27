package com.api.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Miguel Castro
 */
@Entity
public class IMCModel implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Integer idade;

    private Double altura;

    private Double peso;

    public IMCModel() {
    }

    public IMCModel(Long id, Integer idade, Double altura, Double peso) {
        this.id = id;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdade(){
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "IMCModel{" + "id=" + id + ", idade=" + idade + ", altura=" + altura + ", peso=" + peso + '}';
    }
}
