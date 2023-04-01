package com.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 *
 * @author Miguel Castro
 */
@Schema(name = "média de idade por tipo sanguíneo Response DTO")
public class MediaTipoSanguineoResponseDto {

    private Double mediaAPositivo;

    private Double mediaANegativo;

    private Double mediaBPositivo;

    private Double mediaBNegativo;

    private Double mediaOPositivo;

    private Double mediaONegativo;

    private Double mediaABPositivo;

    private Double mediaABNegativo;

    public MediaTipoSanguineoResponseDto() {
    }

    public MediaTipoSanguineoResponseDto(Double mediaAPositivo, Double mediaANegativo, Double mediaBPositivo, Double mediaBNegativo, Double mediaOPositivo, Double mediaONegativo, Double mediaABPositivo, Double mediaABNegativo) {
        this.mediaAPositivo = mediaAPositivo;
        this.mediaANegativo = mediaANegativo;
        this.mediaBPositivo = mediaBPositivo;
        this.mediaBNegativo = mediaBNegativo;
        this.mediaOPositivo = mediaOPositivo;
        this.mediaONegativo = mediaONegativo;
        this.mediaABPositivo = mediaABPositivo;
        this.mediaABNegativo = mediaABNegativo;
    }
    
    public Double getMediaAPositivo() {
        return mediaAPositivo;
    }

    public void setMediaAPositivo(Double mediaAPositivo) {
        this.mediaAPositivo = mediaAPositivo;
    }

    public Double getMediaANegativo() {
        return mediaANegativo;
    }

    public void setMediaANegativo(Double mediaANegativo) {
        this.mediaANegativo = mediaANegativo;
    }

    public Double getMediaBPositivo() {
        return mediaBPositivo;
    }

    public void setMediaBPositivo(Double mediaBPositivo) {
        this.mediaBPositivo = mediaBPositivo;
    }

    public Double getMediaBNegativo() {
        return mediaBNegativo;
    }

    public void setMediaBNegativo(Double mediaBNegativo) {
        this.mediaBNegativo = mediaBNegativo;
    }

    public Double getMediaOPositivo() {
        return mediaOPositivo;
    }

    public void setMediaOPositivo(Double mediaOPositivo) {
        this.mediaOPositivo = mediaOPositivo;
    }

    public Double getMediaONegativo() {
        return mediaONegativo;
    }

    public void setMediaONegativo(Double mediaONegativo) {
        this.mediaONegativo = mediaONegativo;
    }

    public Double getMediaABPositivo() {
        return mediaABPositivo;
    }

    public void setMediaABPositivo(Double mediaABPositivo) {
        this.mediaABPositivo = mediaABPositivo;
    }

    public Double getMediaABNegativo() {
        return mediaABNegativo;
    }

    public void setMediaABNegativo(Double mediaABNegativo) {
        this.mediaABNegativo = mediaABNegativo;
    }
}
