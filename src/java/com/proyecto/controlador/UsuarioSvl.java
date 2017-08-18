
package com.proyecto.controlador;

import com.proyecto.dao.UsuarioDaoImpl;
import com.proyecto.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioSvl", urlPatterns = {"/usuarioSvl"})
public class UsuarioSvl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         Usuario usuario = new Usuario();
         UsuarioDaoImpl usDao = new UsuarioDaoImpl();
         List<Usuario> listaUsuario = new ArrayList();
         String respuesta = null;
         RequestDispatcher rd = null;
            try {
                if (request.getParameter("btnLogin")!=null) {
                    String user = request.getParameter("usuario");
                    String clave = request.getParameter("pass");
                    
                    listaUsuario = (List<Usuario>) usDao.existeUsuario(user, clave);
                    if(listaUsuario.size()>0) {
                        request.setAttribute("listaUsuario", listaUsuario);
                        rd = request.getRequestDispatcher("index.html");
                       
                    }else{
                        respuesta = "Información invalida";
                         request.setAttribute("respuesta", respuesta);
                         rd = request.getRequestDispatcher("login.jsp");
                    }
                }
            } catch (Exception e) {
               out.println("Error en el usuario servlet: " + e.toString());
               e.printStackTrace();
            }
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
