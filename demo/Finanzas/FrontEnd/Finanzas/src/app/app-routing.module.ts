import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContratoListComponent } from './contrato-list/contrato-list.component';
import { CreateContratoComponent } from './create-contrato/create-contrato.component';
import { SearchContratoComponent } from './search-contrato/search-contrato.component';


const routes: Routes = [
  { path: '', redirectTo: 'customer', pathMatch: 'full' },
  { path: 'newContrato', component: CreateContratoComponent },
  { path: 'searchContrato', component: SearchContratoComponent },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
