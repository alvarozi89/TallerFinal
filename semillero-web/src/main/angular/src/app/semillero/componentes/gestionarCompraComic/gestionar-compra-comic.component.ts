import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ComicDTO } from 'src/app/semillero/dto/comic-dto';
import { Router } from '@angular/router';
import { GestionarComicService } from 'src/app/semillero/servicios/gestionar-comic.service';
import Swal from 'sweetalert2'

// CommonJS



//import {NgbModal} from '@ng-bootstrap/ng-bootstrap'

/**
 * @description
 */

@Component({
  selector: 'gestionar-compra-comic',
  templateUrl: './gestionar-compra-comic.component.html',
 
})
export class GestionarCompraComicComponent implements OnInit {

  public gestionarComicForm : FormGroup;

  public comicDTO:ComicDTO;

  public comicDTOInfo : ComicDTO;

  public nombre: string;

  public listaComics: Array<ComicDTO>;

  public mostrarItem: boolean;

  public mostrarModal : boolean;

  public submitted: boolean;
  public mensajeEjecucion : string;

  
  
  constructor(private fb: FormBuilder, private router : Router, private gestionComicsService : GestionarComicService){
    this.gestionarComicForm= this.fb.group({
      nombre: [null,Validators.required],
      editorial : [null,Validators.required],
      tematica : [null],
      coleccion: [null,Validators.required],
      numeroPaginas :[null,Validators.required],
      precio :[null,Validators.required],
      autores : [null],
      color : [null]
    });



  }


  ngOnInit() {
    this.submitted=false;
    this.mostrarItem = false;
    this.mostrarModal= false;
    this.comicDTO = new ComicDTO();
    this.listaComics = new Array<ComicDTO>();
    this.consultarComics();

    
  }

  public consultarComics() {
    this.gestionComicsService.consultarComics().subscribe(data => {
     /* if (data[0].exitoso) {
        this.listaComics = data;
      } else {
        console.log(data[0].mensajeEjecucion);
      }*/
      this.listaComics = data;
    }, error => {
      console.log(error);
    });

  }

  public crearComic(): void{

    this.submitted= true;

    if(this.gestionarComicForm.invalid){

      return;

    }

    
    this.comicDTO= new ComicDTO();
    this.comicDTO.nombre= this.gestionarComicForm.controls.nombre.value;
    this.comicDTO.editorial= this.gestionarComicForm.controls.editorial.value
    this.comicDTO.tematicaEnum= this.gestionarComicForm.controls.tematica.value;
    this.comicDTO.coleccion= this.gestionarComicForm.controls.coleccion.value;
    this.comicDTO.numeroPaginas= this.gestionarComicForm.controls.numeroPaginas.value;
    this.comicDTO.autores= this.gestionarComicForm.controls.autores.value;
    this.comicDTO.precio = this.gestionarComicForm.controls.precio.value;
    this.comicDTO.color= this.gestionarComicForm.controls.color.value;
    this.comicDTO.estadoEnum = "ACTIVO";
    this.comicDTO.cantidad= 3;


    this.gestionComicsService.crearComic(this.comicDTO).subscribe(data=> {
      if (data.exitoso) {
        this.mostrarItem = true;
        this.mensajeEjecucion =data.mensajeEjecucion;
        console.log(data.mensajeEjecucion);
        this.consultarComics();
      } else {
        this.mostrarItem = true;
        this.mensajeEjecucion =data.mensajeEjecucion;
      }
      this.limpiarDatosComic();
    }, error => {
      console.log(error);
    });


    //this.listaComics.push(this.comicDTO);


    Swal.fire(
      'Registro agregado correctamente!',
      'Clic para cotinuar!',
      'success')

    //this.limpiarDatosComic();


    
  }

 


  private limpiarDatosComic():void{

    // comicDTO.nombre= null;
    // comicDTO.coleccion= null;
    // comicDTO.color= null;
    // comicDTO.editorial= null;
    // comicDTO.id= null;
    // comicDTO.tematicaEnum= null;
    // comicDTO.precio= null;
    // comicDTO.numeroPaginas= null;
    // comicDTO.autores= null;

    this.gestionarComicForm.controls.nombre.setValue(null);
    this.gestionarComicForm.controls.editorial.setValue(null);
    this.gestionarComicForm.controls.tematica.setValue(null);
    this.gestionarComicForm.controls.coleccion.setValue(null);
    this.gestionarComicForm.controls.numeroPaginas.setValue(null);
    this.gestionarComicForm.controls.autores.setValue(null);
    this.gestionarComicForm.controls.color.setValue(null);
    this.gestionarComicForm.controls.precio.setValue(null);
    //return [...this.comicDTO]




  }

  public consultarComic(posicion:number):void{
    let comic= this.listaComics[posicion]
    this.f.nombre.setValue(comic.nombre);
    this.f.editorial.setValue(comic.editorial);
    this.f.tematica.setValue(comic.tematicaEnum);
    this.f.coleccion.setValue(comic.coleccion);
    this.f.numeroPaginas.setValue(comic.numeroPaginas);
    this.f.autores.setValue(comic.autores);
    this.f.color.setValue(comic.color);
    this.f.precio.setValue(comic.precio);


    this.f.nombre.disable();
    this.f.editorial.disable();
    this.f.tematica.disable();
    this.f.coleccion.disable();
    this.f.numeroPaginas.disable();
    this.f.autores.disable();
    this.f.color.disable();
    this.f.precio.disable();


  }

  public imprimirInfoComic(posicion:number): void{
    this.mostrarItem= true;
    this.comicDTOInfo = this.listaComics[posicion];


  }

  public activarCampos (): void {

    this.f.nombre.enable();
    this.f.editorial.enable();
    this.f.tematicaEnum.enable();
    this.f.coleccion.enable();
    this.f.numeroPaginas.enable();
    this.f.autores.enable();
    this.f.color.enable();
   


  }


  public eliminarComic(posicion:number): void{
  this.mostrarItem= true;
  this.listaComics.splice(posicion,1);
  //const Swal = require('sweetalert2')
  Swal.fire(
  'Registro eliminado correctamente!',
  'Clic para cotinuar!',
  'error'
)
  


  }

  public ModificarComic(posicion:number): void{
    this.mostrarModal= true;
    this.comicDTOInfo = this.listaComics[posicion];

    
  }

  public AlertaModificar(){
    Swal.fire(
      'Registro modificado correctamente!',
      'Clic para cotinuar!',
      'success')
  }

  public cerrar() : void {
    this.mostrarItem = false;
  }

  public irAComponenteBienvida(comic : ComicDTO) : void {
    this.cerrar();
    this.router.navigate(['bienvenida', comic]);
  }

  get f(){
    return this.gestionarComicForm.controls
  }

   
  public ejecucionEventoClick( parametroEvento : any, numero : number ) : void {
    alert("Hola: " + parametroEvento + ' ' + numero);
    
  }


}
