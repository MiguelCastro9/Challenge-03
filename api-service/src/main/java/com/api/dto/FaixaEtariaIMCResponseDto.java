package com.api.dto;

/**
 *
 * @author Miguel Castro
 */
public class FaixaEtariaIMCResponseDto {

    private String faixaEtaria;

    private Double valorFaixaEtaria;

    public FaixaEtariaIMCResponseDto() {
    }
    
    public FaixaEtariaIMCResponseDto(String faixaEtaria, Double valorFaixaEtaria) {
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
