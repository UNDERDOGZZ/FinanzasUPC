import { Component, OnInit, Input } from '@angular/core';
import { Contrato } from '../model/contrato';
import { ContratoService } from '../contrato.service';

@Component({
  selector: 'app-contrato-details',
  templateUrl: './contrato-details.component.html',
  styleUrls: ['./contrato-details.component.css']
})
export class ContratoDetailsComponent implements OnInit {

  @Input() contrato: Contrato;

  constructor(private contratoService:ContratoService) { }

  ngOnInit() {
  }

}
