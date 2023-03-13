import { Paciente } from './../model/paciente';
import { CadastroService } from './../service/cadastro.service';
import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})


export class CadastroComponent implements OnInit {

  paciente: Paciente = {
    id: 0,
    nome: '',
    cpf: '',
    data_nascimento: new Date(),
    contato: [{
      email: '',
      tipo_contato: '',
      numero: ''
    }],
    endereco: [{
      rua: '',
      numero: 0,
      bairro: '',
      estado: '',
      complemento: ''
    }],
    fisico: {
      altura: 0,
      peso: 0,
      tipo_sanguineo: ''
    }
  };

  alertMensagem = '';
  successMensagem = '';

  constructor(private cadastroService: CadastroService) { }

  ngOnInit(): void {
  }

  validarFormulario() {
    if (!this.paciente.nome) {
      this.alertMensagem = 'Campo nome é obrigatório.';
      return false;
    }
    if (!this.paciente.cpf) {
      this.alertMensagem = 'Campo CPF é obrigatório.';
      return false;
    }
    if (!this.paciente.data_nascimento) {
      this.alertMensagem = 'Campo data de nascimento é obrigatório.';
    }
    let emailsPreenchidos = true;
    this.paciente.contato.forEach(contato => {
      if (!contato.email || !contato.email.match("[A-Za-z0-9._%-]+@[A-Za-z0-9._%-]+\\.[a-z]{2,3}")) {
        emailsPreenchidos = false;
      }
    });
    if (!emailsPreenchidos) {
      this.alertMensagem = 'Todos os campos e-mails dos contatos são obrigatórios.';
    }
    let tipoContatoPreenchidos = true;
    this.paciente.contato.forEach(contato => {
      if (!contato.tipo_contato) {
        tipoContatoPreenchidos = false;
      }
    });
    if (!tipoContatoPreenchidos) {
      this.alertMensagem = 'Todos os campos tipo de contatos são obrigatórios.';
    }
    let numerosContatoPreenchidos = true;
    this.paciente.contato.forEach(contato => {
      if (!contato.numero) {
        numerosContatoPreenchidos = false;
      }
    });
    if (!numerosContatoPreenchidos) {
      this.alertMensagem = 'Todos os campos número de contatos são obrigatórios.';
    }
    let ruaPreenchidas = true;
    this.paciente.endereco.forEach(endereco => {
      if (!endereco.rua) {
        ruaPreenchidas = false;
      }
    });
    if (!ruaPreenchidas) {
      this.alertMensagem = 'Todos os campos rua são obrigatórios.';
    }
    let numerosEnderecoPreenchidos = true;
    this.paciente.endereco.forEach(endereco => {
      if (!endereco.numero) {
        numerosEnderecoPreenchidos = false;
      }
    });
    if (!numerosEnderecoPreenchidos) {
      this.alertMensagem = 'Todos os campos número de endereços são obrigatórios.';
    }
    let bairroPreenchidos = true;
    this.paciente.endereco.forEach(endereco => {
      if (!endereco.bairro) {
        bairroPreenchidos = false;
      }
    });
    if (!bairroPreenchidos) {
      this.alertMensagem = 'Todos os campos bairro são obrigatórios.';
    }
    let estadoPreenchidos = true;
    this.paciente.endereco.forEach(endereco => {
      if (!endereco.estado) {
        estadoPreenchidos = false;
      }
    });
    if (!estadoPreenchidos) {
      this.alertMensagem = 'Todos os campos estado são obrigatórios.';
    }
    if (!this.paciente.fisico.altura) {
      this.alertMensagem = 'Campo altura é obrigatório.';
    }
    if (!this.paciente.fisico.peso) {
      this.alertMensagem = 'Campo peso é obrigatório.';
    }
    if (!this.paciente.fisico.tipo_sanguineo) {
      this.alertMensagem = 'Campo tipo sanguíneo é obrigatório.';
    }
  return true;
  }

  salvar(paciente: Paciente) {
    if (!this.validarFormulario()) {
      return;
    }
    this.cadastroService.salvar(paciente)
    .subscribe(dados => {
      this.successMensagem = 'Cadastro realizado com sucesso!';
      this.paciente = {
        id: 0,
        nome: '',
        cpf: '',
        data_nascimento: new Date(),
        contato: [{
          email: '',
          tipo_contato: '',
          numero: ''
        }],
        endereco: [{
          rua: '',
          numero: 0,
          bairro: '',
          estado: '',
          complemento: ''
        }],
        fisico: {
          altura: 0,
          peso: 0,
          tipo_sanguineo: ''
        }
      };
    },
    (erro: HttpErrorResponse) => {
      if (erro.error && erro.error.length > 0) {
        this.alertMensagem = erro.error[0].mensagemUsuario;
      } else {
        this.alertMensagem = erro.message;
      }
    });
  }
}
