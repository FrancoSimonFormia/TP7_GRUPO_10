package dao;

import java.util.List;

import entidad.Seguro;

public interface SeguroDao {
	
	public int obtenerUltimoID();
	
	public boolean insert (Seguro seguro);
	
	List<Seguro> listarSeguros();
}
