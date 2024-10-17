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
            <td><label>ID Seguro:</label></td>
            <td><label id="idseguro"><%= request.getAttribute("proximoIdSeguro") %></label>
			<input type="hidden" name="idseguro" value="<%= request.getAttribute("proximoIdSeguro") %>"></td>
        </tr>

        <tr>
            <td><label>Descripci�n:</label></td>
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
            <td><label>Costo Contrataci�n:</label></td>
            <td><input type="text" id="costoContratacion" name="costoContratacion"></td>
        </tr>

        <tr>
            <td><label>Costo M�ximo Asegurado:</label></td>
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
    });

    function validarFormulario() {
        var descripcion = document.getElementById("descripcion").value;
        var costoContratacion = document.getElementById("costoContratacion").value;
        var costoMaximo = document.getElementById("costoMaximo").value;

        var soloNumeros = /^\d+(\.\d{1,2})?$/;

        if (descripcion === "") {
            alert("El campo 'Descripci�n' no puede estar vac�o.");
            return false;
        }

        if (costoContratacion === "" || !soloNumeros.test(costoContratacion)) {
            alert("'Costo Contrataci�n' debe ser un n�mero valido.");
            return false;
        }

        if (costoMaximo === "" || !soloNumeros.test(costoMaximo)) {
            alert("'Costo M�ximo Asegurado' debe ser un numero v�lido.");
            return false;
        }

        return true;
    }

</script>

</body>
</html>