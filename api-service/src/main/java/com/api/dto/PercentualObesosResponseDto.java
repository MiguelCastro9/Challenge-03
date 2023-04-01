package com.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 *
 * @author Miguel Castro
 */
@Schema(name = "percentual de obesos Response DTO")
public class PercentualObesosResponseDto {

    private Double percentualMasculino;

    private Double percentualFeminino;

    public PercentualObesosResponseDto() {
    }

    public PercentualObesosResponseDto(Double percentualMasculino, Double percentualFeminino) {
        this.percentualMasculino = percentualMasculino;
        this.percentualFeminino = percentualFeminino;
    }

    public Double getPercentualMasculino() {
        return percentualMasculino;
    }

    public void setPercentualMasculino(Double percentualMasculino) {
        this.percentualMasculino = percentualMasculino;
    }

    public Double getPercentualFeminino() {
        return percentualFeminino;
    }

    public void setPercentualFeminino(Double percentualFeminino) {
        this.percentualFeminino = percentualFeminino;
    }
}
