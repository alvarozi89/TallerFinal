package com.hbt.semillero.dto;

import java.math.BigDecimal;

import com.hbt.semillero.enums.EstadoEnum;

public class GenerarCompraDTO extends ResultadoDTO{
	

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private short cantidad;
	private EstadoEnum estadoEnum;
	
	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	
	
	 public GenerarCompraDTO() {
	    	
			
		} 
		
	
    public GenerarCompraDTO(String nombre,short cantidad,EstadoEnum estadoEnum) {
    	this.nombre = nombre;
    	this.cantidad = cantidad;
		this.estadoEnum=estadoEnum;
	}
	
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo CANTIDAD
	 * @return El precios asociado a la clase
	 */
	public short getCantidad() {
		return cantidad;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo CANTIDAD
	 * @param precios El nuevo precios a modificar.
	 */
	public void setCantidad(short cantidad) {
		this.cantidad = cantidad;
	}
	
	public EstadoEnum getEstadoEnum() {
		return estadoEnum;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo estadoEnum
	 * @param estadoEnum El nuevo estadoEnum a modificar.
	 */
	public void setEstadoEnum(EstadoEnum estadoEnum) {
		this.estadoEnum = estadoEnum;
	}
	

}
