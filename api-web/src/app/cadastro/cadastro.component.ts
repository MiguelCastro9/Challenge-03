import { Paciente } from './../model/paciente';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  paciente = new Paciente();
  alertMensagem = '';

  constructor() { }

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
    if (!this.paciente.endereco.rua) {
      this.alertMensagem = 'Campo rua é obrigatório.';
    }
    if (!this.paciente.endereco.numero) {
      this.alertMensagem = 'Campo número é obrigatório.';
    }
    if (!this.paciente.endereco.bairro) {
      this.alertMensagem = 'Campo bairro é obrigatório.';
    }
    if (!this.paciente.endereco.estado) {
      this.alertMensagem = 'Campo estado é obrigatório.';
    }
    if (!this.paciente.contato.email) {
      this.alertMensagem = 'Campo e-mail é obrigatório.';
    }
    if (!this.paciente.contato.email.match("[A-Za-z0-9._%-]+@[A-Za-z0-9._%-]+\\.[a-z]{2,3}")) {
      this.alertMensagem = 'Campo e-mail inválido.';
      return false;
    }
    if (!this.paciente.contato.tipo_contato) {
      this.alertMensagem = 'Campo tipo de contato é obrigatório.';
    }
    if (!this.paciente.contato.numero) {
      this.alertMensagem = 'Campo número é obrigatório.';
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

}
