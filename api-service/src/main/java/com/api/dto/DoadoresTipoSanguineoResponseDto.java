package com.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 *
 * @author Miguel Castro
 */
@Schema(name = "doadores para cada tipo sanguineo Response DTO")
public class DoadoresTipoSanguineoResponseDto {

    private String descDoadoresAPositivo;

    private Integer totalDoadoresAPositivo;

    private String descDoadoresANegativo;

    private Integer totalDoadoresANegativo;

    private String descDoadoresBPositivo;

    private Integer totalDoadoresBPositivo;

    private String descDoadoresBNegativo;

    private Integer totalDoadoresBNegativo;

    private String descDoadoresOPositivo;

    private Integer totalDoadoresOPositivo;

    private String descDoadoresONegativo;

    private Integer totalDoadoresONegativo;

    private String descDoadoresABPositivo;

    private Integer totalDoadoresABPositivo;

    private String descDoadoresABNegativo;

    private Integer totalDoadoresABNegativo;

    public DoadoresTipoSanguineoResponseDto() {
    }

    public DoadoresTipoSanguineoResponseDto(String descDoadoresAPositivo, Integer totalDoadoresAPositivo, String descDoadoresANegativo, Integer totalDoadoresANegativo, String descDoadoresBPositivo, Integer totalDoadoresBPositivo, String descDoadoresBNegativo, Integer totalDoadoresBNegativo, String descDoadoresOPositivo, Integer totalDoadoresOPositivo, String descDoadoresONegativo, Integer totalDoadoresONegativo, String descDoadoresABPositivo, Integer totalDoadoresABPositivo, String descDoadoresABNegativo, Integer totalDoadoresABNegativo) {
        this.descDoadoresAPositivo = descDoadoresAPositivo;
        this.totalDoadoresAPositivo = totalDoadoresAPositivo;
        this.descDoadoresANegativo = descDoadoresANegativo;
        this.totalDoadoresANegativo = totalDoadoresANegativo;
        this.descDoadoresBPositivo = descDoadoresBPositivo;
        this.totalDoadoresBPositivo = totalDoadoresBPositivo;
        this.descDoadoresBNegativo = descDoadoresBNegativo;
        this.totalDoadoresBNegativo = totalDoadoresBNegativo;
        this.descDoadoresOPositivo = descDoadoresOPositivo;
        this.totalDoadoresOPositivo = totalDoadoresOPositivo;
        this.descDoadoresONegativo = descDoadoresONegativo;
        this.totalDoadoresONegativo = totalDoadoresONegativo;
        this.descDoadoresABPositivo = descDoadoresABPositivo;
        this.totalDoadoresABPositivo = totalDoadoresABPositivo;
        this.descDoadoresABNegativo = descDoadoresABNegativo;
        this.totalDoadoresABNegativo = totalDoadoresABNegativo;
    }

    public String getDescDoadoresAPositivo() {
        return descDoadoresAPositivo;
    }

    public void setDescDoadoresAPositivo(String descDoadoresAPositivo) {
        this.descDoadoresAPositivo = descDoadoresAPositivo;
    }

    public Integer getTotalDoadoresAPositivo() {
        return totalDoadoresAPositivo;
    }

    public void setTotalDoadoresAPositivo(Integer totalDoadoresAPositivo) {
        this.totalDoadoresAPositivo = totalDoadoresAPositivo;
    }

    public String getDescDoadoresANegativo() {
        return descDoadoresANegativo;
    }

    public void setDescDoadoresANegativo(String descDoadoresANegativo) {
        this.descDoadoresANegativo = descDoadoresANegativo;
    }

    public Integer getTotalDoadoresANegativo() {
        return totalDoadoresANegativo;
    }

    public void setTotalDoadoresANegativo(Integer totalDoadoresANegativo) {
        this.totalDoadoresANegativo = totalDoadoresANegativo;
    }

    public String getDescDoadoresBPositivo() {
        return descDoadoresBPositivo;
    }

    public void setDescDoadoresBPositivo(String descDoadoresBPositivo) {
        this.descDoadoresBPositivo = descDoadoresBPositivo;
    }

    public Integer getTotalDoadoresBPositivo() {
        return totalDoadoresBPositivo;
    }

    public void setTotalDoadoresBPositivo(Integer totalDoadoresBPositivo) {
        this.totalDoadoresBPositivo = totalDoadoresBPositivo;
    }

    public String getDescDoadoresBNegativo() {
        return descDoadoresBNegativo;
    }

    public void setDescDoadoresBNegativo(String descDoadoresBNegativo) {
        this.descDoadoresBNegativo = descDoadoresBNegativo;
    }

    public Integer getTotalDoadoresBNegativo() {
        return totalDoadoresBNegativo;
    }

    public void setTotalDoadoresBNegativo(Integer totalDoadoresBNegativo) {
        this.totalDoadoresBNegativo = totalDoadoresBNegativo;
    }

    public String getDescDoadoresOPositivo() {
        return descDoadoresOPositivo;
    }

    public void setDescDoadoresOPositivo(String descDoadoresOPositivo) {
        this.descDoadoresOPositivo = descDoadoresOPositivo;
    }

    public Integer getTotalDoadoresOPositivo() {
        return totalDoadoresOPositivo;
    }

    public void setTotalDoadoresOPositivo(Integer totalDoadoresOPositivo) {
        this.totalDoadoresOPositivo = totalDoadoresOPositivo;
    }

    public String getDescDoadoresONegativo() {
        return descDoadoresONegativo;
    }

    public void setDescDoadoresONegativo(String descDoadoresONegativo) {
        this.descDoadoresONegativo = descDoadoresONegativo;
    }

    public Integer getTotalDoadoresONegativo() {
        return totalDoadoresONegativo;
    }

    public void setTotalDoadoresONegativo(Integer totalDoadoresONegativo) {
        this.totalDoadoresONegativo = totalDoadoresONegativo;
    }

    public String getDescDoadoresABPositivo() {
        return descDoadoresABPositivo;
    }

    public void setDescDoadoresABPositivo(String descDoadoresABPositivo) {
        this.descDoadoresABPositivo = descDoadoresABPositivo;
    }

    public Integer getTotalDoadoresABPositivo() {
        return totalDoadoresABPositivo;
    }

    public void setTotalDoadoresABPositivo(Integer totalDoadoresABPositivo) {
        this.totalDoadoresABPositivo = totalDoadoresABPositivo;
    }

    public String getDescDoadoresABNegativo() {
        return descDoadoresABNegativo;
    }

    public void setDescDoadoresABNegativo(String descDoadoresABNegativo) {
        this.descDoadoresABNegativo = descDoadoresABNegativo;
    }

    public Integer getTotalDoadoresABNegativo() {
        return totalDoadoresABNegativo;
    }

    public void setTotalDoadoresABNegativo(Integer totalDoadoresABNegativo) {
        this.totalDoadoresABNegativo = totalDoadoresABNegativo;
    }
}
