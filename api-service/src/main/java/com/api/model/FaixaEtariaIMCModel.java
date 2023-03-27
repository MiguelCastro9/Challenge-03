package com.api.model;

/**
 *
 * @author Miguel Castro
 */
public class FaixaEtariaIMCModel {

    private String faixaEtaria;

    private Double valorFaixaEtaria;

    public FaixaEtariaIMCModel() {
    }
    
    public FaixaEtariaIMCModel(String faixaEtaria, Double valorFaixaEtaria) {
        this.faixaEtaria = faixaEtaria;
        this.valorFaixaEtaria = valorFaixaEtaria;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public Double getValorFaixaEtaria() {
        return valorFaixaEtaria;
    }

    public void setValorFaixaEtaria(Double valorFaixaEtaria) {
        this.valorFaixaEtaria = valorFaixaEtaria;
    }
}
