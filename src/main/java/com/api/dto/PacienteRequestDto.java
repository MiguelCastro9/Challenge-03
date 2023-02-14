package com.api.dto;

import com.api.model.ContatoModel;
import com.api.model.EnderecoModel;
import com.api.model.FisicoModel;
import com.api.model.PacienteModel;
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
public class PacienteRequestDto {
    
    @NotBlank(message = "Nome é obrigatório.")
    @Length(min = 3, max = 40, message = "Nome requer no mínimo {min} e no máximo {max} caracteres.")
    private String nome;
    @CPF(message = "CPF mal formatado.")
    private String cpf;
    @NotNull(message = "Data de nascimento é obrigatório.")
    private Date data_nascimento;
    @NotBlank(message = "Endereço é obrigatório.")
    private List<EnderecoModel> endereco;
    @NotBlank(message = "Contato é obrigatório.")
    private List<ContatoModel> contato;
    @NotBlank(message = "Físico é obrigatório.")
    private FisicoModel fisico;
    
    //Método para converter entidade em DTO e salvar.
    public PacienteModel converterPacienteDtoParaEntidade() {
        return new PacienteModel(nome, cpf, data_nascimento, endereco, contato, fisico);
    }
}
