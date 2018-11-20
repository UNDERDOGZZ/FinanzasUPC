import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateContratoComponent } from './create-contrato/create-contrato.component';
import { ContratoDetailsComponent } from './contrato-details/contrato-details.component';
import { ConratoListComponent } from './conrato-list/conrato-list.component';
import { SearchContratoComponent } from './search-contrato/search-contrato.component';
import { CreateUsuarioComponent } from './create-usuario/create-usuario.component';
import { SearchUsuarioComponent } from './search-usuario/search-usuario.component'
import { HttpClientModule } from '@angular/common/http';
import {FormsModule} from '@angular/forms';
@NgModule({
  declarations: [
    AppComponent,
    CreateContratoComponent,
    ContratoDetailsComponent,
    ConratoListComponent,
    SearchContratoComponent,
    CreateUsuarioComponent,
    SearchUsuarioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule ,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
