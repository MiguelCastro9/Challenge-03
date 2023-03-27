package com.api.model;

/**
 *
 * @author Miguel Castro
 */
public class IMCModel {

    private Long id;

    private Long data_nascimento;

    private Double altura;

    private Double peso;

    public IMCModel() {
    }

    public IMCModel(Long id, Long data_nascimento, Double altura, Double peso) {
        this.id = id;
        this.data_nascimento = data_nascimento;
        this.altura = altura;
        this.peso = peso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Long data_nascimento) {
        this.data_nascimento = data_nascimento;
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
}
