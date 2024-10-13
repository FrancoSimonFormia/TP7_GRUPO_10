package negocio;

import java.util.List;

import entidad.Seguro;

public interface SeguroNegocio {
	
	public boolean insert(Seguro seguro);
	
	List<Seguro> listarSeguros();
	
}
