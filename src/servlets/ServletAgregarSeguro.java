package servlets;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImplementacion.SeguroDaoImp;
import negocioImplementacion.SeguroNegocioImp;
import negocioImplementacion.TipoSeguroNegocioImp;
import entidad.Seguro;
import entidad.TipoSeguro;

@WebServlet("/ServletAgregarSeguro")
public class ServletAgregarSeguro extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	Seguro s = new Seguro();
        boolean insert = false;
        try {
            //Obtengo los parámetros desde el formulario
            int idSeguro = Integer.parseInt(request.getParameter("idseguro"));
            String descripcion = request.getParameter("descripcion");
            int idTipo = Integer.parseInt(request.getParameter("tipo"));
            double costoContratacion = Double.parseDouble(request.getParameter("costoContratacion"));
            double costoAsegurado = Double.parseDouble(request.getParameter("costoMaximo"));

            // Seteo los valores en el objeto
            s.setIdSeguro(idSeguro);
            s.setDescripcion(descripcion);
            s.setIdTipo(idTipo);
            s.setCostoContratacion(costoContratacion);
            s.setCostoAsegurado(costoAsegurado);

            // Inserto el objeto en la base de datos usando el DAO
            SeguroDaoImp sdao = new SeguroDaoImp();
            insert = sdao.insert(s);

        } catch (NumberFormatException e) {
            // Manejar la excepción en caso de errores de conversión de tipos
            e.printStackTrace();
        }
        
        
        SeguroNegocioImp seguroNegocioImp = new SeguroNegocioImp();
        TipoSeguroNegocioImp tipoSeguroNegocioImp = new TipoSeguroNegocioImp();
        
        int proximoIdSeguro = seguroNegocioImp.obtenerUltimoID() + 1;

        List<TipoSeguro> listaTipos = tipoSeguroNegocioImp.listarTiposDeSeguros();         
        
        request.setAttribute("proximoIdSeguro", proximoIdSeguro);
        request.setAttribute("listaTipos", listaTipos);             

        request.getRequestDispatcher("AgregarSeguro.jsp").forward(request, response);
    }
}