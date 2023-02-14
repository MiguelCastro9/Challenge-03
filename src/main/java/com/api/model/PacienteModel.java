package com.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Miguel Castro
 */
@Entity
@Table(name = "paciente")
public class PacienteModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false)
    private Long id;

    private String nome;

    private String cpf;

    @Temporal(TemporalType.DATE)
    private Date data_nascimento;

    @OneToMany(mappedBy = "paciente", targetEntity = EnderecoModel.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EnderecoModel> endereco;

    @OneToMany(mappedBy = "paciente", targetEntity = ContatoModel.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ContatoModel> contato;

    @OneToOne(cascade = CascadeType.ALL)
    private FisicoModel fisico;

    public PacienteModel() {
    }

    public PacienteModel(String nome, String cpf, Date data_nascimento, List<EnderecoModel> endereco, List<ContatoModel> contato, FisicoModel fisico) {
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.endereco = endereco;
        this.contato = contato;
        this.fisico = fisico;
    }

    public PacienteModel(Long id, String nome, String cpf, Date data_nascimento, List<EnderecoModel> endereco, List<ContatoModel> contato, FisicoModel fisico) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.endereco = endereco;
        this.contato = contato;
        this.fisico = fisico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public List<EnderecoModel> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<EnderecoModel> endereco) {
        this.endereco = endereco;
    }

    public List<ContatoModel> getContato() {
        return contato;
    }

    public void setContato(List<ContatoModel> contato) {
        this.contato = contato;
    }

    public FisicoModel getFisico() {
        return fisico;
    }

    public void setFisico(FisicoModel fisico) {
        this.fisico = fisico;
    }
}
