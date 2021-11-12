package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.GenerarCompraDTO;
import com.hbt.semillero.ejb.IGestionarCompraComic;

@Path("/gestionarCompraComic")
public class GestionarCompraComicRest {
	
	@EJB
	private IGestionarCompraComic gestionarCompraComic;
	@GET
	@Path("/comprarComic")
	@Produces(MediaType.APPLICATION_JSON)

	public GenerarCompraDTO generarCompra(@QueryParam("idComic")Long idComic ) {
		
		return this.gestionarCompraComic.generarCompra(idComic);
	}

}
