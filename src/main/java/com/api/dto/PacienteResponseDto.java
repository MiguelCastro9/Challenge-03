package com.api.dto;

import com.api.model.ContatoModel;
import com.api.model.EnderecoModel;
import com.api.model.FisicoModel;
import com.api.model.PacienteModel;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Miguel Castro
 */
public class PacienteResponseDto {

    private Long id;
    private String nome;
    private String cpf;
    private Date data_nascimento;
    private List<EnderecoModel> endereco;
    private List<ContatoModel> contato;
    private FisicoModel fisico;

    public PacienteResponseDto(Long id, String nome, String cpf, Date data_nascimento, List<EnderecoModel> endereco, List<ContatoModel> contato, FisicoModel fisico) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.endereco = endereco;
        this.contato = contato;
        this.fisico = fisico;
    }

    //Método para converter entidade em DTO.
    public static PacienteResponseDto converterEntidadeParaPacienteDto(PacienteModel pacienteModel) {
        return new PacienteResponseDto(pacienteModel.getId(), pacienteModel.getNome(), pacienteModel.getCpf(),
                pacienteModel.getData_nascimento(), pacienteModel.getEndereco(), pacienteModel.getContato(),
                pacienteModel.getFisico());
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
