import { Fisico } from './fisico';
import { Contato } from './contato';
import { Endereco } from './endereco';
export class Paciente {

  id!: number;
  nome!: string;
  cpf!: string;
  data_nascimento!: Date;
  endereco!: Endereco;
  contato!: Contato;
  fisico!: Fisico;

  constructor() {}
}

