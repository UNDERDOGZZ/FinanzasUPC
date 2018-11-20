import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateContratoComponent } from './create-contrato/create-contrato.component';
import { ContratoDetailsComponent } from './contrato-details/contrato-details.component';
import { ContratoListComponent } from './contrato-list/contrato-list.component';
import { SearchContratoComponent } from './search-contrato/search-contrato.component';
import { CreateUsuarioComponent } from './create-usuario/create-usuario.component';
import { SearchUsuarioComponent } from './search-usuario/search-usuario.component'
import { HttpClientModule } from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { FlujoListComponent } from './flujo-list/flujo-list.component';
import { FlujoDetailsComponent } from './flujo-details/flujo-details.component';
import { LoginComponent } from './login/login.component';
import { ResultadoListComponent } from './resultado-list/resultado-list.component';
@NgModule({
  declarations: [
    AppComponent,
    CreateContratoComponent,
    ContratoDetailsComponent,
    ContratoListComponent,
    SearchContratoComponent,
    CreateUsuarioComponent,
    SearchUsuarioComponent,
    FlujoListComponent,
    FlujoDetailsComponent,
    LoginComponent,
    ResultadoListComponent
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
