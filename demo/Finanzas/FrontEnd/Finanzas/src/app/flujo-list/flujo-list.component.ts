import { Component, OnInit, Input } from '@angular/core';
import { Contrato } from '../model/contrato';
import { FlujoService } from '../flujo.service';
import { Flujo } from '../model/flujo';

@Component({
  selector: 'app-flujo-list',
  templateUrl: './flujo-list.component.html',
  styleUrls: ['./flujo-list.component.css']
})
export class FlujoListComponent implements OnInit {

  flujos:Flujo[];
  
  @Input() contrato: Contrato;

  constructor(private flujoService: FlujoService) { 
  }

  ngOnInit() {
    this.flujoService.getByContrato(this.contrato.id).
    subscribe(data => this.flujos = data);
  }

}
