package com.api.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Miguel Castro
 */
@Entity
public class DataModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Integer idade;

    private String genero;

    private Double altura;

    private Double peso;

    private String tipo_sanguineo;

    public DataModel() {
    }

    public DataModel(Long id, Integer idade, String genero, Double altura, Double peso, String tipo_sanguineo) {
        this.id = id;
        this.idade = idade;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
        this.tipo_sanguineo = tipo_sanguineo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    public String getTipo_sanguineo() {
        return tipo_sanguineo;
    }

    public void setTipo_sanguineo(String tipo_sanguineo) {
        this.tipo_sanguineo = tipo_sanguineo;
    }

    @Override
    public String toString() {
        return "DataModel{" + "id=" + id + ", idade=" + idade + ", genero=" + genero + ", altura=" + altura + ", peso=" + peso + ", tipo_sanguineo=" + tipo_sanguineo + '}';
    }
}
