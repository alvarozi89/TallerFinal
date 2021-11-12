package com.hbt.semillero.dto;

import java.util.ArrayList;
import java.util.List;

public class ConsultaLengthNombreComicDTO extends ResultadoDTO{
	
	
	private static final long serialVersionUID = 1L;
	private List<String> comicsSupermanTamanio;
	private List<String> ComicsNoSupermanTamanio;
	
	
	 public ConsultaLengthNombreComicDTO() {
		 this.ComicsNoSupermanTamanio= new ArrayList<>();
		 this.ComicsNoSupermanTamanio= new ArrayList<>();
	    	
			
		}
	 
	 

	/**
	 * Metodo encargado de retornar el valor del atributo comicSupermanTamanio
	 * @return El comicSupermanTamanio asociado a la clase
	 */
	public List<String> getComicsSupermanTamanio() {
		return comicsSupermanTamanio;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo comicSupermanTamanio
	 * @param comicSupermanTamanio El nuevo comicSupermanTamanio a modificar.
	 */
	public void setComicsSupermanTamanio(List<String> comicSupermanTamanio) {
		this.comicsSupermanTamanio = comicSupermanTamanio;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo ComicsNoSupermanTamanio
	 * @return El comicsNoSupermanTamanio asociado a la clase
	 */
	public List<String> getComicsNoSupermanTamanio() {
		return ComicsNoSupermanTamanio;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo ComicsNoSupermanTamanio
	 * @param comicsNoSupermanTamanio El nuevo comicsNoSupermanTamanio a modificar.
	 */
	public void setComicsNoSupermanTamanio(List<String> comicsNoSupermanTamanio) {
		ComicsNoSupermanTamanio = comicsNoSupermanTamanio;
	}
	
	
		


}
