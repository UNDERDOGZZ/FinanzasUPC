import { Component, OnInit } from '@angular/core';
import { ContratoService } from '../contrato.service';
import { Contrato } from '../model/contrato';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-create-contrato',
  templateUrl: './create-contrato.component.html',
  styleUrls: ['./create-contrato.component.css']
})
export class CreateContratoComponent implements OnInit {

  usuario: any;
  usuarioaux: Usuario = new Usuario();
  contrato: Contrato = new Contrato();
  selectedMoneda: string;
  selectedPlazo: string;

  constructor(private contratoService: ContratoService,
    private usuarioService: UsuarioService) { }

  ngOnInit() {
    this.usuarioService.getUsuario(1).subscribe(data=>this.usuario=data);
  }

  save(){

    this.contrato.usuarioId=this.usuario;
    this.contratoService.createContrato(this.contrato)
    .subscribe(data=>console.log(data),error=>console.log(error));
    this.contrato=new Contrato();
  }
}
