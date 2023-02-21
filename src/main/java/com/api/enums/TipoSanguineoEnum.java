package com.api.enums;

/**
 *
 * @author Miguel Castro
 */
public enum TipoSanguineoEnum {

    A_POSITIVO("A+"),
    A_NEGATIVO("A-"),
    B_POSITIVO("B+"),
    B_NEGATIVO("B-"),
    A_B_POSITIVO("AB+"),
    A_B_NEGATIVO("AB-"),
    O_POSITIVO("O+"),
    O_NEGATIVO("O-");

    private String tipo_sanguineo;

    private TipoSanguineoEnum(String tipo_sanguineo) {
        this.tipo_sanguineo = tipo_sanguineo;
    }

    public String getTipo_sanguineo() {
        return tipo_sanguineo;
    }

    public void setTipo_sanguineo(String tipo_sanguineo) {
        this.tipo_sanguineo = tipo_sanguineo;
    }
}
