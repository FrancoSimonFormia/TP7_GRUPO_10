package daoImplementacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.TipoSeguroDao;
import entidad.TipoSeguro;

public class TipoSeguroDaoImp implements TipoSeguroDao {
	
	private static final String qrylistartiposeguros = "SELECT idTipo, descripcion FROM segurosgroup.tiposeguros;";
	private static final String qryBuscarPorId = "SELECT idTipo, descripcion FROM tipoSeguros WHERE idTipo = ?";
	
	public List<TipoSeguro> listarTiposDeSeguros() {		
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
	    finally {
	        Conexion.getConexion().cerrarConexion();
	    }


	    return tiposDeSeguros;
	}

	@Override
	public TipoSeguro buscarPorId(int idTipo) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		TipoSeguro tipoSeguro = null;
		try {
			
			PreparedStatement statement;
			Connection conexion = Conexion.getConexion().getSQLConexion();
			statement = conexion.prepareStatement(qryBuscarPorId);
			statement.setInt(1, idTipo);
		    ResultSet resultSet = statement.executeQuery();

		    while (resultSet.next()) {
	            int id = resultSet.getInt("idTipo");
	            String descripcion = resultSet.getString("descripcion");

	            tipoSeguro = new TipoSeguro(id, descripcion);
	        }

		    } catch (SQLException e) {
		        e.printStackTrace(); 
		    }finally {
		        Conexion.getConexion().cerrarConexion();
		    }

				
		return tipoSeguro;
		
	}


}
