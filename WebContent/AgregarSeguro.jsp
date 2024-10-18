<%@page import="entidad.TipoSeguro" %>
<%@page import="java.util.List" %>
<%@page import="entidad.Seguro" %>
<%@page import="daoImplementacion.SeguroDaoImp" %>

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
<a href="Inicio.jsp">Inicio</a>
<a href="ServletAgregarSeguro">Agregar Seguro</a>
<a href="ServletListarSeguros"> Listar Seguros</a>

<h1>Agregar Seguro</h1>

<form action="ServletAgregarSeguro" method="get">
    <table>
        <tr>
            <td><label>ID Seguro:</label></td>
            <td><label id="idseguro"><%= request.getAttribute("proximoIdSeguro") %></label>
			<input id="ids" type="hidden" name="idseguro" value="<%= request.getAttribute("proximoIdSeguro") %>"></td>
        </tr>

        <tr>
            <td><label>Descripción:</label></td>
            <td><input type="text" id="descripcion" name="descripcion"></td>
        </tr>

        <tr>
            <td><label>Tipo Seguro:</label></td>
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
            <td><label>Costo Contratación:</label></td>
            <td><input type="text" id="costoContratacion" name="costoContratacion"></td>
        </tr>

        <tr>
            <td><label>Costo Máximo Asegurado:</label></td>
            <td><input type="text" id="costoMaximo" name="costoMaximo"></td>
        </tr>

        <tr>
            <td colspan="2" style="text-align: right;">
                <button type="submit" id="btnAceptar">Aceptar</button>
            </td>
        </tr>
    </table>
</form>

<script>
    var botonAceptar = document.getElementById("btnAceptar");

    botonAceptar.addEventListener("click", function(event) {
        if (!validarFormulario()) {
            event.preventDefault();
        }
        else alert("Seguro agregado con éxito!");
    });

    function validarFormulario() {
        var descripcion = document.getElementById("descripcion").value;
        var costoContratacion = document.getElementById("costoContratacion").value;
        var costoMaximo = document.getElementById("costoMaximo").value;

        var soloNumeros = /^\d+(\.\d{1,2})?$/;

        if (descripcion === "") {
            alert("El campo 'Descripción' no puede estar vacío.");
            return false;
        }
        
        if (costoContratacion < 0 || costoMaximo < 0){
        	alert("No puede ingresar valores de costos negativos");
        	return false;
        }

        if (costoContratacion === "" || !soloNumeros.test(costoContratacion)) {
            alert("'Costo Contratación' debe ser un número valido.");
            return false;
        }
        
        if (costoContratacion > costoMaximo){
        	alert("'Costo Contratación' no puede ser mayor al 'Costo Máximo Asegurado'");
        	return false;
        }
        

        if (costoMaximo === "" || !soloNumeros.test(costoMaximo)) {
            alert("'Costo Máximo Asegurado' debe ser un numero válido.");
            return false;
        }

        return true;
    }

</script>

</body>
</html>