package com.hbt.semillero.dto;


import java.math.BigDecimal;
import java.util.List;

public class ConsultarComicTamanioNombreDTO extends ResultadoDTO {
	
	private static final long serialVersionUID = 1L;
	private List<String> comicSupermanTamanio;
	private List<String> ComicsNoSupermanTamanio;
	/**
	 * Metodo encargado de retornar el valor del atributo comicSupermanTamanio
	 * @return El comicSupermanTamanio asociado a la clase
	 */
	public List<String> getComicSupermanTamanio() {
		return comicSupermanTamanio;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo comicSupermanTamanio
	 * @param comicSupermanTamanio El nuevo comicSupermanTamanio a modificar.
	 */
	public void setComicSupermanTamanio(List<String> comicSupermanTamanio) {
		this.comicSupermanTamanio = comicSupermanTamanio;
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

	

	
	 public ConsultarComicTamanioNombreDTO() {
	    	
			
		} 
	 
	  public ConsultarComicTamanioNombreDTO(String nombre) {
	    	
	    
			
		}
	
	 

}
