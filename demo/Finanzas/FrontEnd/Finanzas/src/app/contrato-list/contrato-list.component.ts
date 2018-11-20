import { Component, OnInit, Input } from '@angular/core';
import { Contrato } from '../model/contrato';
import { ContratoService } from '../contrato.service';

@Component({
  selector: 'app-contrato-list',
  templateUrl: './contrato-list.component.html',
  styleUrls: ['./contrato-list.component.css']
})
export class ContratoListComponent implements OnInit {

  @Input() contratos:Contrato[];
  constructor(private contratoService: ContratoService) { }

  ngOnInit() {
  }

}
