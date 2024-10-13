package daoImplementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SeguroDao;
import entidad.Seguro;

public class SeguroDaoImp {
	
	private static final String qrylistarseguros = "SELECT idSeguro, descripcion, idTipo, costoContratacion, costoAsegurado FROM Seguros";
	
	public static List<Seguro> listarSeguros() {
		
	    List<Seguro> seguros = new ArrayList<>();

	    try (Connection conexion = Conexion.getConexion().getSQLConexion();
	         PreparedStatement statement = conexion.prepareStatement(qrylistarseguros);
	         ResultSet resultSet = statement.executeQuery()) {

	        while (resultSet.next()) {
	            int idSeguro = resultSet.getInt("idSeguro");
	            String descripcion = resultSet.getString("descripcion");
	            int idTipo = resultSet.getInt("idTipo");
	            double costoContratacion = resultSet.getDouble("costoContratacion");
	            double costoAsegurado = resultSet.getDouble("costoAsegurado");

	         
	            Seguro seguro = new Seguro(idSeguro, descripcion, idTipo, costoContratacion, costoAsegurado);
	            seguros.add(seguro);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }

	    return seguros;
	}
	

}
