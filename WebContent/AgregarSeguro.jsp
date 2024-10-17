<%@page import="entidad.TipoSeguro" %>
<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar Seguro</title>
</head>
<body>

<h1>Agregar Seguro</h1>

<form action="ServletAgregarSeguro" method="post">
    <table>
        <tr>
            <td><label for="idseguro">ID Seguro:</label></td>
            <td><input type="text" id="idseguro" name="idseguro"></td>
        </tr>

        <tr>
            <td><label for="descripcion">Descripción:</label></td>
            <td><input type="text" id="descripcion" name="descripcion"></td>
        </tr>

        <tr>
            <td><label for="tipo">Tipo Seguro:</label></td>
            <td>
                <select id="tipo" name="tipo">
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
            </td>
        </tr>

        <tr>
            <td><label for="costoContratacion">Costo Contratación:</label></td>
            <td><input type="text" id="costoContratacion" name="costoContratacion"></td>
        </tr>

        <tr>
            <td><label for="costoMaximo">Costo Máximo Asegurado:</label></td>
            <td><input type="text" id="costoMaximo" name="costoMaximo"></td>
        </tr>

        <tr>
            <td colspan="2" style="text-align: center;">
                <button type="submit">Aceptar</button>
            </td>
        </tr>
    </table>
</form>

</body>
</html>