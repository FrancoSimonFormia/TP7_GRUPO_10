package negocioImplementacion;

import java.util.List;

import dao.TipoSeguroDao;
import daoImplementacion.TipoSeguroDaoImp;
import entidad.TipoSeguro;
import negocio.TipoSeguroNegocio;

public class TipoSeguroNegocioImp implements TipoSeguroNegocio {
	
	TipoSeguroDao tsDao = new TipoSeguroDaoImp();

	@Override
	public List<TipoSeguro> listarTiposDeSeguros() {

		return tsDao.listarTiposDeSeguros();
	}

	@Override
	public TipoSeguro buscarPorId(int idTipo) {
		
		return tsDao.buscarPorId(idTipo);
	}
	

}
