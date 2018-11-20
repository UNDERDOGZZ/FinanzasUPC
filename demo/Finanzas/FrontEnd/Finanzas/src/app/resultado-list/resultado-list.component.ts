import { Component, OnInit, Input } from '@angular/core';
import { Resultado } from '../model/resultado';
import { Contrato } from '../model/contrato';
import { ResultadoService } from '../resultado.service';

@Component({
  selector: 'app-resultado-list',
  templateUrl: './resultado-list.component.html',
  styleUrls: ['./resultado-list.component.css']
})
export class ResultadoListComponent implements OnInit {

  resultado:any;

  @Input() contrato: Contrato;
  constructor(private resultadoService: ResultadoService) { }

  ngOnInit() {
    this.resultadoService.getAllResultadoByContratoId(this.contrato.id).
    subscribe(data => this.resultado = data);
  }

}
