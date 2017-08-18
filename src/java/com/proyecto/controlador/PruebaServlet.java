
package com.proyecto.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.proyecto.dao.ProductoDaoImpl;
import com.proyecto.modelo.Producto;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "PruebaServlet", urlPatterns = {"/pruebasv"})
public class PruebaServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ProductoDaoImpl prodDao =  new ProductoDaoImpl();
            Producto producto = new Producto();
            
            String respuesta = null;
            RequestDispatcher rd = null;
            try {
                if(request.getParameter("btnRegistrar")!=null){
                    producto.setCodProducto(request.getParameter("codigo"));
                    producto.setNombre(request.getParameter("nombre"));
                    producto.setPrecioCompra(Double.parseDouble(request.getParameter("compra")));
                    producto.setPrecioVenta(Double.parseDouble(request.getParameter("venta")));
                    producto.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
                    producto.setIdCategoria(Integer.parseInt(request.getParameter("categoria")));
                    //prod.setEstado(request.getParameter("estado"));
                    producto.setEstado("Activo");
                    respuesta =  prodDao.insertar(producto);
                    request.setAttribute("respuesta", respuesta);
                    rd = request.getRequestDispatcher("productos.jsp");
                }else if(request.getParameter("btnEliminar")!=null){
                    producto.setIdProducto(request.getParameter("cod"));
                    prodDao.eliminar(producto);
                    //request.setAttribute("respuesta", respuesta);
                    rd = request.getRequestDispatcher("productos.jsp");
                }else if(request.getParameter("btnModificar")!=null){
                      producto = (Producto) prodDao.buscarPorID(request.getParameter("codigo"));

                    request.setAttribute("producto", producto);
                    rd = request.getRequestDispatcher("ver_producto.jsp");
                }
                 
            } catch (NumberFormatException | SQLException e) {
                System.out.println("Problemas en el server: " + e.toString());
            }
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
