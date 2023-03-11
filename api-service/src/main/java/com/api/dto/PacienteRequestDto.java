package com.api.dto;

import com.api.model.ContatoModel;
import com.api.model.EnderecoModel;
import com.api.model.FisicoModel;
import com.api.model.PacienteModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Miguel Castro
 */
@Schema(name = "paciente Request DTO")
public class PacienteRequestDto {

    @NotBlank(message = "Nome é obrigatório.")
    @Length(min = 3, max = 40, message = "Nome requer no mínimo {min} e no máximo {max} caracteres.")
    private String nome;
    @CPF(message = "CPF mal formatado.")
    private String cpf;
    @NotNull(message = "Data de nascimento é obrigatório.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data_nascimento;
    @NotNull(message = "Endereço é obrigatório.")
    private List<EnderecoModel> endereco;
    @NotNull(message = "Contato é obrigatório.")
    private List<ContatoModel> contato;
    @NotNull(message = "Físico é obrigatório.")
    private FisicoModel fisico;

    public PacienteModel converterPacienteDtoParaEntidade() {
        return new PacienteModel(nome, cpf, data_nascimento, endereco, contato, fisico);
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

    @Override
    public String toString() {
        return "PacienteRequestDto{" + "nome=" + nome + ", cpf=" + cpf + ", data_nascimento=" + data_nascimento + ", endereco=" + endereco + ", contato=" + contato + ", fisico=" + fisico + '}';
    }
}
