package dao;

import java.util.List;

import entidad.TipoSeguro;

public interface TipoSeguroDao {
	
	public boolean insert (TipoSeguro tipoSeguro);
	
	List<TipoSeguro> listarTiposDeSeguros();
}
