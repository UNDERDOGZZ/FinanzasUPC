import { Component } from '@angular/core';
import { UsuarioService } from './usuario.service';
import { Usuario } from './model/usuario';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Finanzas';
  usuarios:Usuario[];
  nombre: string;
  contra: string;
  exito: boolean = false;
  constructor(private usuarioService: UsuarioService) { }

  ngOnInit() {
    this.usuarioService.getUsuariosList()
      .subscribe(usuarios => this.usuarios = usuarios);
  }

  login()
  {
    for(var i=0; i < this.usuarios.length; i++){
   if(this.nombre == this.usuarios[i].nombreUsuario && this.contra == this.usuarios[i].contrasena)
    {
      this.exito = true;
    }
    }
  }
}
