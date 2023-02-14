package com.api.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Miguel Castro
 */
@Entity
@Table(name = "contato")
public class ContatoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String tipo_contato;

    @Column(nullable = false)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteModel paciente;

    public ContatoModel() {
    }

    public ContatoModel(Long id, String email, String tipo_contato, String numero, PacienteModel paciente) {
        this.id = id;
        this.email = email;
        this.tipo_contato = tipo_contato;
        this.numero = numero;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo_contato() {
        return tipo_contato;
    }

    public void setTipo_contato(String tipo_contato) {
        this.tipo_contato = tipo_contato;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public PacienteModel getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteModel paciente) {
        this.paciente = paciente;
    }
}
