package daoImplementacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.TipoSeguroDao;
import entidad.TipoSeguro;

public class TipoSeguroDaoImp {
	
	private static final String qrylistartiposeguros = "SELECT idTipo, descripcion FROM tipoSeguros";
	
	public static List<TipoSeguro> listarTiposDeSeguros() {
	    List<TipoSeguro> tiposDeSeguros = new ArrayList<>();
	    

	    try (Connection conexion = Conexion.getConexion().getSQLConexion();
	         PreparedStatement statement = conexion.prepareStatement(qrylistartiposeguros);
	         ResultSet resultSet = statement.executeQuery()) {

	        while (resultSet.next()) {
	            int idTipo = resultSet.getInt("idTipo");
	            String descripcion = resultSet.getString("descripcion");

	   
	            TipoSeguro tipoSeguro = new TipoSeguro(idTipo, descripcion);
	            tiposDeSeguros.add(tipoSeguro);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }

	    return tiposDeSeguros;
	}

}
