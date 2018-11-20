import { Component, OnInit, Input } from '@angular/core';
import { Contrato } from '../model/contrato';
import { ContratoService } from '../contrato.service';
import { FlujoService } from '../flujo.service';

@Component({
  selector: 'app-contrato-details',
  templateUrl: './contrato-details.component.html',
  styleUrls: ['./contrato-details.component.css']
})
export class ContratoDetailsComponent implements OnInit {

  mostrarflujo: boolean = false;
  mostrarresultado: boolean = false;

  @Input() contrato: Contrato;

  constructor(private contratoService:ContratoService,
    private flujoService:FlujoService) { }

  ngOnInit() {
  }

  mostrarF()
  {
    this.mostrarflujo = !this.mostrarflujo;
  }
  mostrarR()
  {
    this.mostrarresultado = !this.mostrarresultado;
  }
}
