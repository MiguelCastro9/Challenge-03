package com.api.model;

import com.api.enums.GeneroEnum;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Temporal(TemporalType.DATE)
    private Date data_nascimento;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;

    @OneToMany(mappedBy = "id", targetEntity = EnderecoModel.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EnderecoModel> endereco;

    @OneToMany(mappedBy = "id", targetEntity = ContatoModel.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ContatoModel> contato;

    @OneToOne(targetEntity = FisicoModel.class, cascade = CascadeType.ALL)
    private FisicoModel fisico;

    public PacienteModel() {
    }

    public PacienteModel(String nome, String cpf, Date data_nascimento, GeneroEnum genero, List<EnderecoModel> endereco, List<ContatoModel> contato, FisicoModel fisico) {
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.genero = genero;
        this.endereco = endereco;
        this.contato = contato;
        this.fisico = fisico;
    }

    public PacienteModel(Long id, String nome, String cpf, Date data_nascimento, GeneroEnum genero, List<EnderecoModel> endereco, List<ContatoModel> contato, FisicoModel fisico) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.genero = genero;
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

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
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
