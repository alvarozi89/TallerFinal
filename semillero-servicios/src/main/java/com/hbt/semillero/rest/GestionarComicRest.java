package com.hbt.semillero.rest;



import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ConsultaLengthNombreComicDTO;
import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ConsultarComicDTO;
//import com.hbt.semillero.dto.ConsultarComicTamanioNombreDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;

@Path("/gestionarComic")
public class GestionarComicRest {
	
@EJB
private IGestionarComicLocal gestionarComicLocal;
@GET
@Path("/ConsultaNombrePrecioComic")
@Produces(MediaType.APPLICATION_JSON)

public ConsultaNombrePrecioComicDTO consultaNombrePrecioComic(@QueryParam("idComic")Long idComic ) {
	
	return this.gestionarComicLocal.consultarNombrePrecioComic(idComic);
	
}


@GET
@Path("/consultarComic")
@Produces(MediaType.APPLICATION_JSON)

public List <ComicDTO> consultarComic() {
	
	return  this.gestionarComicLocal.consultarComics();
	
	
}






/*@GET
@Path("/consultarComicTamanioNombre ")
@Produces(MediaType.APPLICATION_JSON)

public ConsultarComicTamanioNombreDTO consultarComicTamanioNombre(@QueryParam("nombre")String nombre ) {
	
	return this.gestionarComicLocal.consultarComicTamanioNombre(nombre);
	
}*/



@GET
@Path("/consultarComicTamanioNombre ")
@Produces(MediaType.APPLICATION_JSON)

public ConsultaLengthNombreComicDTO consultaLengthNombreComicDTO(@QueryParam("lengthCadena")Short lengthCadena ) {
	
	return this.gestionarComicLocal.consultaLengthNombreComicDTO(lengthCadena);

}
	
@POST
@Path("/crearComic")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
 public ComicDTO crearComic(ComicDTO comicDTO) {
	ComicDTO comicDTOResult =new ComicDTO();
	try {
		
		comicDTOResult= this.gestionarComicLocal.crearComic(comicDTO);
		
	}
	catch(Exception e) {
		comicDTOResult.setExitoso(false);
		comicDTOResult.setMensajeEjecucion("Se ha presentado un error tecnico "+e.getMessage());
		
	}
	
	return comicDTOResult;
	 
 }

}
