import { Paciente } from './../model/paciente';
import { environment } from './../../environments/environment.dev';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CadastroService {

  api_url = environment.api_url;

  constructor(private http: HttpClient) { }

  salvar(paciente: Paciente){
    return this.http.post<Paciente>(this.api_url, paciente);
  }
}
