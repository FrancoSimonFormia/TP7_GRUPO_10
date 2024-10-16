package servlets;

import java.util.List;
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

@WebServlet("/ServletListarSeguros")
public class ServletListarSeguros extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        SeguroNegocioImp seguroNegocioImp = new SeguroNegocioImp();
        TipoSeguroNegocioImp tipoSeguroNegocioImp = new TipoSeguroNegocioImp();
        
        List<Seguro> listaSeguros = seguroNegocioImp.listarSeguros();
        List<TipoSeguro> listaTipos = tipoSeguroNegocioImp.listarTiposDeSeguros();
        
        request.setAttribute("listaSeguros", listaSeguros);
        request.setAttribute("listaTipos", listaTipos);
        
        request.getRequestDispatcher("ListarSeguros.jsp").forward(request, response);
    }
}
