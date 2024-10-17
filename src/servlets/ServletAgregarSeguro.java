package servlets;

import java.util.List;
import java.util.ArrayList; // Asegúrate de importar esta clase
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocioImplementacion.SeguroNegocioImp;
import negocioImplementacion.TipoSeguroNegocioImp;
import entidad.Seguro;
import entidad.TipoSeguro;

@WebServlet("/ServletAgregarSeguro")
public class ServletAgregarSeguro extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        SeguroNegocioImp seguroNegocioImp = new SeguroNegocioImp();
        TipoSeguroNegocioImp tipoSeguroNegocioImp = new TipoSeguroNegocioImp();
        
        List<TipoSeguro> listaTipos = new ArrayList<>();        
               
        listaTipos = tipoSeguroNegocioImp.listarTiposDeSeguros();         
                      
        String tipoSeguroSeleccionado = request.getParameter("tipoSeguro");
        
        request.setAttribute("listaTipos", listaTipos);             
       
        request.getRequestDispatcher("AgregarSeguro.jsp").forward(request, response);
    }
}
