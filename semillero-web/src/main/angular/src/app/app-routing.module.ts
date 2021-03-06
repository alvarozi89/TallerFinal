import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic/gestionar-comic.component';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { GestionarCompraComicComponent } from './semillero/componentes/gestionarCompraComic/gestionar-compra-comic.component';
import swal from'sweetalert2';

const routes: Routes = [
  { path: 'bienvenida',component: BienvenidaComponent,data : null},
  { path: 'gestionar-comic',component: GestionarComicComponent},
  { path: 'gestionar-compra-comit',component: GestionarCompraComicComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
