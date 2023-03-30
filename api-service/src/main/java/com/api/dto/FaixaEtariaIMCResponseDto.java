package com.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 *
 * @author Miguel Castro
 */
@Schema(name = "faixa etaria IMC Response DTO")
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
