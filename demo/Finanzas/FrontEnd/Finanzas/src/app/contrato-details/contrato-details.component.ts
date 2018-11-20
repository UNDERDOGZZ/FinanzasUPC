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

  seCreoFlujo: boolean = false;

  @Input() contrato: Contrato;

  constructor(private contratoService:ContratoService,
    private flujoService:FlujoService) { }

  ngOnInit() {
  }

  crearFlujo()
  {
    this.seCreoFlujo = true;
    this.flujoService.saveFlujo(this.contrato).
    subscribe(data=>console.log(data),error=>console.log(error));
  }
}
