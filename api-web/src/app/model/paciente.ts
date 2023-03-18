import { Fisico } from './fisico';
import { Contato } from "./contato";
import { Endereco } from "./endereco";

export interface Paciente {

  id: number;
  nome: string;
  cpf: string;
  data_nascimento?: Date;
  contato: Contato[];
  endereco: Endereco[];
  fisico: Fisico;

}
