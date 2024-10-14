<%@page import="negocioImplementacion.SeguroNegocioImp"%>
<%@page import="entidad.TipoSeguro" %>
<%@page import="entidad.Seguro" %>
<%@page import="java.util.List" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<a href="Inicio.jsp">Inicio</a>
	<a href="AgregarSeguro.jsp"> Agregar Seguro</a>
	<a href="ListarSeguros.jsp"> Listar Seguros</a>

	<h3>"Tipo de seguros de la base de datos"</h3>


	Busqueda por tipo de seguros 
	
	<table border="1">
		<tr>
			<th> ID Seguro</th> 
			<th> Descripción seguro </th> 
			<th> Descripción tipo seguro </th> 
			<th> Costo contratación </th> 
			<th> Costo máximo asegurado </th> 
		 </tr>
		 
		 <% 
		 
		List<Seguro> listaSeguros = null;
		SeguroNegocioImp seguroNegocioImp = new SeguroNegocioImp();
			
		listaSeguros = seguroNegocioImp.listarSeguros();
		 
		 if(listaSeguros != null)
		 {
			for(Seguro s : listaSeguros)
				 {%>
			<tr>
			
				<td> <%=s.getIdSeguro() %> </td>
				<td> <%=s.getDescripcion() %> </td>
				<td> Descripcion del tipo... </td>
				<td> <%=s.getCostoContratacion() %> </td>
				<td> <%= s.getCostoAsegurado() %></td>
		
			</tr>
				<%}
				 	 
			} %>
	</table>

</body>
</html>