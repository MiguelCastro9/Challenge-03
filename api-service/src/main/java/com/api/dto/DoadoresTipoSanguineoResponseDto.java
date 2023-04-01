package com.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 *
 * @author Miguel Castro
 */
@Schema(name = "doadores para cada tipo sanguineo Response DTO")
public class DoadoresTipoSanguineoResponseDto {

    private Integer totalDoadoresAPositivo;

    private Integer totalDoadoresANegativo;

    private Integer totalDoadoresBPositivo;

    private Integer totalDoadoresBNegativo;

    private Integer totalDoadoresOPositivo;

    private Integer totalDoadoresONegativo;

    private Integer totalDoadoresABPositivo;

    private Integer totalDoadoresABNegativo;

    public DoadoresTipoSanguineoResponseDto() {
    }

    public DoadoresTipoSanguineoResponseDto(Integer totalDoadoresAPositivo, Integer totalDoadoresANegativo, Integer totalDoadoresBPositivo, Integer totalDoadoresBNegativo, Integer totalDoadoresOPositivo, Integer totalDoadoresONegativo, Integer totalDoadoresABPositivo, Integer totalDoadoresABNegativo) {
        this.totalDoadoresAPositivo = totalDoadoresAPositivo;
        this.totalDoadoresANegativo = totalDoadoresANegativo;
        this.totalDoadoresBPositivo = totalDoadoresBPositivo;
        this.totalDoadoresBNegativo = totalDoadoresBNegativo;
        this.totalDoadoresOPositivo = totalDoadoresOPositivo;
        this.totalDoadoresONegativo = totalDoadoresONegativo;
        this.totalDoadoresABPositivo = totalDoadoresABPositivo;
        this.totalDoadoresABNegativo = totalDoadoresABNegativo;
    }

    public Integer getTotalDoadoresAPositivo() {
        return totalDoadoresAPositivo;
    }

    public void setTotalDoadoresAPositivo(Integer totalDoadoresAPositivo) {
        this.totalDoadoresAPositivo = totalDoadoresAPositivo;
    }

    public Integer getTotalDoadoresANegativo() {
        return totalDoadoresANegativo;
    }

    public void setTotalDoadoresANegativo(Integer totalDoadoresANegativo) {
        this.totalDoadoresANegativo = totalDoadoresANegativo;
    }

    public Integer getTotalDoadoresBPositivo() {
        return totalDoadoresBPositivo;
    }

    public void setTotalDoadoresBPositivo(Integer totalDoadoresBPositivo) {
        this.totalDoadoresBPositivo = totalDoadoresBPositivo;
    }

    public Integer getTotalDoadoresBNegativo() {
        return totalDoadoresBNegativo;
    }

    public void setTotalDoadoresBNegativo(Integer totalDoadoresBNegativo) {
        this.totalDoadoresBNegativo = totalDoadoresBNegativo;
    }

    public Integer getTotalDoadoresOPositivo() {
        return totalDoadoresOPositivo;
    }

    public void setTotalDoadoresOPositivo(Integer totalDoadoresOPositivo) {
        this.totalDoadoresOPositivo = totalDoadoresOPositivo;
    }

    public Integer getTotalDoadoresONegativo() {
        return totalDoadoresONegativo;
    }

    public void setTotalDoadoresONegativo(Integer totalDoadoresONegativo) {
        this.totalDoadoresONegativo = totalDoadoresONegativo;
    }

    public Integer getTotalDoadoresABPositivo() {
        return totalDoadoresABPositivo;
    }

    public void setTotalDoadoresABPositivo(Integer totalDoadoresABPositivo) {
        this.totalDoadoresABPositivo = totalDoadoresABPositivo;
    }

    public Integer getTotalDoadoresABNegativo() {
        return totalDoadoresABNegativo;
    }

    public void setTotalDoadoresABNegativo(Integer totalDoadoresABNegativo) {
        this.totalDoadoresABNegativo = totalDoadoresABNegativo;
    }
}
