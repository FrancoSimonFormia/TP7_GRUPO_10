package daoImplementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SeguroDao;
import entidad.Seguro;

public class SeguroDaoImp implements SeguroDao {
	
	private static final String qrylistarseguros = "SELECT idSeguro, descripcion, idTipo, costoContratacion, costoAsegurado FROM Seguros";
	
	public List<Seguro> listarSeguros() {
		
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
	
	private static final String qryinsert = "INSERT INTO seguros(idSeguro, descripcion, idTipo, costoContratacion, costoAsegurado) VALUES(?, ?, ?, ?, ?)";

	@Override
	public boolean insert(Seguro seguro) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(qryinsert);
			statement.setInt(1, seguro.getIdSeguro());
			statement.setString(2, seguro.getDescripcion());
			statement.setInt(3, seguro.getIdTipo());
			statement.setDouble(4, seguro.getCostoContratacion());
			statement.setDouble(5, seguro.getCostoAsegurado());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}

	

}
