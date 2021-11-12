package com.hbt.semillero.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.GenerarCompraDTO;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarCompraComicBean implements IGestionarCompraComic{
	
	
	@PersistenceContext
	private EntityManager em;

	
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)	
public GenerarCompraDTO generarCompra(Long idComic) {
	/**
	 * SQL para traer los datos de nombre,cantidad,estado por parametro id
	 */
		
		String consulta = "SELECT new com.hbt.semillero.dto.GenerarCompraDTO (c.nombre,c.cantidad,c.estadoEnum)FROM Comic c WHERE c.id=:idComic";
		GenerarCompraDTO generarCompraDTO = new GenerarCompraDTO();
		try {
			Query consultaNativa = em.createQuery(consulta);
			consultaNativa.setParameter("idComic", idComic);
			generarCompraDTO= (GenerarCompraDTO)consultaNativa.getSingleResult();
			generarCompraDTO.setExitoso(true);
			generarCompraDTO.setMensajeEjecucion("Se ejecuto correctamente");
		
			
			
		}
		
		catch(Exception e) {
			
			generarCompraDTO.setExitoso(false);
			generarCompraDTO.setMensajeEjecucion("Se presento un error en la consulta");
			
		}
		
	  return generarCompraDTO;
		
		
	}

}
