package dao;

import java.util.List;

import entidad.Seguro;

public interface SeguroDao {
	
	public boolean insert (Seguro seguro);
	
	List<Seguro> listarSeguros();
}
