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

@WebServlet("/ServletListarSeguros")
public class ServletListarSeguros extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        SeguroNegocioImp seguroNegocioImp = new SeguroNegocioImp();
        TipoSeguroNegocioImp tipoSeguroNegocioImp = new TipoSeguroNegocioImp();
        
  
        List<Seguro> listaSeguros = new ArrayList<>();
        List<TipoSeguro> listaTipos = new ArrayList<>();        
        
        listaSeguros = seguroNegocioImp.listarSeguros();    
        listaTipos = tipoSeguroNegocioImp.listarTiposDeSeguros();         
                      
        String tipoSeguroSeleccionado = request.getParameter("tipoSeguro");
        List<Seguro> listaSegurosFiltrados = new ArrayList<>();
   
        if (tipoSeguroSeleccionado != null && !tipoSeguroSeleccionado.isEmpty()) {
            int idTipoSeguro = Integer.parseInt(tipoSeguroSeleccionado);
            for (Seguro seguro : listaSeguros) {
                if (seguro.getIdTipo() == idTipoSeguro) {
                    listaSegurosFiltrados.add(seguro);
                }
            }
        } else {
            // Si no hay tipo seleccionado, usamos la lista original
            listaSegurosFiltrados = listaSeguros;
        }
        
        
        
        request.setAttribute("listaSeguros", listaSegurosFiltrados);
        
        request.setAttribute("listaTipos", listaTipos);             
       
        request.getRequestDispatcher("ListarSeguros.jsp").forward(request, response);
    }
}
