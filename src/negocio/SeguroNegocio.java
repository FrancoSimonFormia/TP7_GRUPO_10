package negocio;

import java.util.List;

import entidad.Seguro;

public interface SeguroNegocio {
	
	public int obtenerUltimoID();
	
	public boolean insert(Seguro seguro);
	
	List<Seguro> listarSeguros();
	
}
