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
    data_nascimento: undefined,
    contato: [{
      email: '',
      tipo_contato: '',
      numero: ''
    }],
    endereco: [{
      rua: '',
      numero: NaN,
      bairro: '',
      estado: '',
      complemento: ''
    }],
    fisico: {
      altura: NaN,
      peso: NaN,
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
      return false;
    }
    let emailsPreenchidos = true;
    this.paciente.contato.forEach(contato => {
      if (!contato.email || !contato.email.match("[A-Za-z0-9._%-]+@[A-Za-z0-9._%-]+\\.[a-z]{2,3}")) {
        emailsPreenchidos = false;
      }
    });
    if (!emailsPreenchidos) {
      this.alertMensagem = 'Campo e-mail é obrigatório.';
      return false;
    }
    let tipoContatoPreenchidos = true;
    this.paciente.contato.forEach(contato => {
      if (!contato.tipo_contato) {
        tipoContatoPreenchidos = false;
      }
    });
    if (!tipoContatoPreenchidos) {
      this.alertMensagem = 'Campo tipo de contato é obrigatório.';
      return false;
    }
    let numerosContatoPreenchidos = true;
    this.paciente.contato.forEach(contato => {
      if (!contato.numero) {
        numerosContatoPreenchidos = false;
      }
    });
    if (!numerosContatoPreenchidos) {
      this.alertMensagem = 'Campo número de contato é obrigatório.';
      return false;
    }
    let ruaPreenchidas = true;
    this.paciente.endereco.forEach(endereco => {
      if (!endereco.rua) {
        ruaPreenchidas = false;
      }
    });
    if (!ruaPreenchidas) {
      this.alertMensagem = 'Campo rua é obrigatório.';
      return false;
    }
    let numerosEnderecoPreenchidos = true;
    this.paciente.endereco.forEach(endereco => {
      if (!endereco.numero) {
        numerosEnderecoPreenchidos = false;
      }
    });
    if (!numerosEnderecoPreenchidos) {
      this.alertMensagem = 'Campo número de endereço é obrigatório.';
      return false;
    }
    let bairroPreenchidos = true;
    this.paciente.endereco.forEach(endereco => {
      if (!endereco.bairro) {
        bairroPreenchidos = false;
      }
    });
    if (!bairroPreenchidos) {
      this.alertMensagem = 'Campo bairro é obrigatório.';
      return false;
    }
    let estadoPreenchidos = true;
    this.paciente.endereco.forEach(endereco => {
      if (!endereco.estado) {
        estadoPreenchidos = false;
      }
    });
    if (!estadoPreenchidos) {
      this.alertMensagem = 'Campo estado é obrigatório.';
      return false;
    }
    if (!this.paciente.fisico.altura) {
      this.alertMensagem = 'Campo altura é obrigatório.';
      return false;
    }
    if (!this.paciente.fisico.peso) {
      this.alertMensagem = 'Campo peso é obrigatório.';
      return false;
    }
    if (!this.paciente.fisico.tipo_sanguineo) {
      this.alertMensagem = 'Campo tipo sanguíneo é obrigatório.';
      return false;
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
        data_nascimento: undefined,
        contato: [{
          email: '',
          tipo_contato: '',
          numero: ''
        }],
        endereco: [{
          rua: '',
          numero: NaN,
          bairro: '',
          estado: '',
          complemento: ''
        }],
        fisico: {
          altura: NaN,
          peso: NaN,
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
