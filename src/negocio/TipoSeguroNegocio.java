package negocio;

import java.util.List;

import entidad.TipoSeguro;

public interface TipoSeguroNegocio {

	List<TipoSeguro> listarTiposDeSeguros();
	
	TipoSeguro buscarPorId(int idTipo);
}
