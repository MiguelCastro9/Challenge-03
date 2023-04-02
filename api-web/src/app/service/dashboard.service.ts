import { Paciente } from './../model/paciente';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.dev';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  api_url = environment.api_url;

  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<Paciente[]>(this.api_url);
  }

  estados(estado: string) {
    return this.http.get<number>(this.api_url + '/' + estado);
  }

  imcs() {
    return this.http.get<any[]>(this.api_url + '/imcs');
  }

  obesos() {
    return this.http.get<any>(this.api_url + '/obesos');
  }

  medias() {
    return this.http.get<any>(this.api_url + '/medias');
  }

  doadores() {
    return this.http.get<any>(this.api_url + '/doadores');
  }
}
