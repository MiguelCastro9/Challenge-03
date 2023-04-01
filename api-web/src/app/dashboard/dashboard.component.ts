import { Paciente } from './../model/paciente';
import { DashboardService } from './../service/dashboard.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  estado!: string;
  listaPacientes: Paciente[] = [];
  totalEstadosPacientes!: number;
  listaImcsPacientes: any[] = [];
  obesosPacientes: any;
  mediasPacientes: any;
  doadoresPacientes: any;
  p = 1;


  constructor(private dashboardService: DashboardService) { }

  ngOnInit(): void {
    this.listar();
    this.imcs();
    this.obesos();
    this.medias();
    this.doadores();
  }

  listar() {
    this.dashboardService.listar().subscribe(dados => this.listaPacientes = dados);
  }

  estados(estado: string) {
    this.dashboardService.estados(this.estado).subscribe(dados => this.totalEstadosPacientes = dados);
  }

  imcs() {
    this.dashboardService.imcs().subscribe(dados => this.listaImcsPacientes = dados);
  }

  obesos() {
    this.dashboardService.obesos().subscribe(dados => this.obesosPacientes = dados);
  }

  medias() {
    this.dashboardService.medias().subscribe(dados => this.mediasPacientes = dados);
  }

  doadores() {
    this.dashboardService.doadores().subscribe(dados => this.doadoresPacientes = dados);
  }
}
