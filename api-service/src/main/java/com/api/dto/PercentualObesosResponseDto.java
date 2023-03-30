package com.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 *
 * @author Miguel Castro
 */
@Schema(name = "percentual de obesos Response DTO")
public class PercentualObesosResponseDto {

    private Double pencetualMasculino;

    private Double percentualFeminino;

    public PercentualObesosResponseDto() {
    }

    public PercentualObesosResponseDto(Double pencetualMasculino, Double percentualFeminino) {
        this.pencetualMasculino = pencetualMasculino;
        this.percentualFeminino = percentualFeminino;
    }

    public Double getPencetualMasculino() {
        return pencetualMasculino;
    }

    public void setPencetualMasculino(Double pencetualMasculino) {
        this.pencetualMasculino = pencetualMasculino;
    }

    public Double getPercentualFeminino() {
        return percentualFeminino;
    }

    public void setPercentualFeminino(Double percentualFeminino) {
        this.percentualFeminino = percentualFeminino;
    }
}
