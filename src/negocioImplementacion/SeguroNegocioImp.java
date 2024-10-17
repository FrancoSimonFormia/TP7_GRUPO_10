package negocioImplementacion;

import java.util.List;

import dao.SeguroDao;
import daoImplementacion.SeguroDaoImp;
import entidad.Seguro;
import negocio.SeguroNegocio;

public class SeguroNegocioImp implements SeguroNegocio {
	
	SeguroDao sDao = new SeguroDaoImp();

	@Override
	public boolean insert(Seguro seguro) {
		
		boolean estado=false;
		estado=sDao.insert(seguro);
		return estado;
		
	}

	@Override
	public List<Seguro> listarSeguros() {
		return sDao.listarSeguros();
	}

	@Override
	public int obtenerUltimoID() {
		return sDao.obtenerUltimoID();
	}

}
