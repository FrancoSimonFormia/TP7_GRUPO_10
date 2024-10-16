<%@page import="entidad.TipoSeguro" %>
<%@page import="entidad.Seguro" %>
<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Listar Seguros</title>
</head>
<body>
<a href="Inicio.jsp">Inicio</a>
<a href="ServletAgregarSeguro">Agregar Seguro</a>
<a href="ServletListarSeguros"> Listar Seguros</a>

    <h3>"Tipo de seguros de la base de datos"</h3>
    
   <form action="ServletListarSeguros" method="get">
        <label for="tipoSeguro">B�squeda por tipo de seguro:</label>
        <select id="tipoSeguro" name="tipoSeguro">
            <% 
                List<TipoSeguro> listaTipos = (List<TipoSeguro>) request.getAttribute("listaTipos");
                if (listaTipos != null) {
                    for (TipoSeguro ts : listaTipos) {
            %>
                <option value="<%= ts.getIdTipo() %>"><%= ts.getDescripcion() %></option>
            <% 
                    }
                }
            %>
        </select>       
        <button type="submit">Filtrar</button>
    </form>


    <table border="1">
        <tr>
            <th>ID Seguro</th> 
            <th>Descripci�n seguro</th> 
            <th>Descripci�n tipo seguro</th> 
            <th>Costo contrataci�n</th> 
            <th>Costo m�ximo asegurado</th> 
        </tr>
         
        <% 
            List<Seguro> listaSeguros = (List<Seguro>) request.getAttribute("listaSeguros");
            if (listaSeguros != null) {
                for (Seguro s : listaSeguros) {
                    String tipoDescripcion = "Tipo de seguro no encontrado";
                    
                    for (TipoSeguro ts : listaTipos) {
                        if (ts.getIdTipo() == s.getIdTipo()) {
                            tipoDescripcion = ts.getDescripcion();
                            break;
                        }
                    }
        %>
            <tr>
                <td><%= s.getIdSeguro() %></td>
                <td><%= s.getDescripcion() %></td>
                <td><%= tipoDescripcion %></td>
                <td><%= s.getCostoContratacion() %></td>
                <td><%= s.getCostoAsegurado() %></td>
            </tr>
        <% } } %>
    </table>
</body>
</html>
