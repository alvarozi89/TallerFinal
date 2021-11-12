package com.hbt.semillero.ejb;

import javax.ejb.Local;


import com.hbt.semillero.dto.GenerarCompraDTO;

@Local
public interface IGestionarCompraComic {
	
	
	public GenerarCompraDTO generarCompra(Long idComic);

}
