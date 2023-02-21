package com.api.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Miguel Castro
 */
@Entity
@Table(name = "fisico")
public class FisicoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double altura;

    @Column(nullable = false)
    private Double peso;

    @Column(nullable = false)
    private String tipo_sanguineo;

    public FisicoModel() {
    }

    public FisicoModel(Long id, Double altura, Double peso, String tipo_sanguineo) {
        this.id = id;
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

    public double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public double getPeso() {
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
        return "FisicoModel{" + "id=" + id + ", altura=" + altura + ", peso=" + peso + ", tipo_sanguineo=" + tipo_sanguineo + '}';
    }
}
