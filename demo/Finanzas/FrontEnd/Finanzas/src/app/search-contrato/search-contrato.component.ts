import { Component, OnInit } from '@angular/core';
import { Contrato } from '../model/contrato';
import { ContratoService } from '../contrato.service';

@Component({
  selector: 'app-search-contrato',
  templateUrl: './search-contrato.component.html',
  styleUrls: ['./search-contrato.component.css']
})
export class SearchContratoComponent implements OnInit {

  text:string = "";
  contratos:Contrato[];

  constructor(private contratoService: ContratoService) { }

  ngOnInit() {
    this.searchContrato();
  }

  searchContrato()
  {
    if(this.text.length > 0)
    {
      this.contratoService.getContratosByEmpresa(this.text)
     .subscribe(contratos=>this.contratos=contratos);
    }
    else{
      this.contratoService.getContratos()
      .subscribe(contratos => this.contratos = contratos);
    }
  }
}
