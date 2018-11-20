import { Component, OnInit, Input } from '@angular/core';
import { Contrato } from '../model/contrato';
import { ContratoService } from '../contrato.service';
import { FlujoService } from '../flujo.service';
import { SearchContratoComponent } from '../search-contrato/search-contrato.component';

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
    private flujoService:FlujoService, private listComponent: SearchContratoComponent) { }

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

  Eliminar()
  {
    this.contratoService.deleteContrato(this.contrato.id)
    .subscribe(data=>{ this.listComponent.searchContrato();
      },
      error => console.log(error));
  }
}
