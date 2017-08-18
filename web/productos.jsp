<%-- 
    Document   : registrar_productos.jsp
    Created on : 17/07/2017, 09:58:52 PM
    Author     : toshiba
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.proyecto.modelo.Producto"%>
<%@page import="java.util.List"%>
<%@page import="com.proyecto.dao.ProductoDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
   

    <title>Dashboard - Sistema de Gestión</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

   
    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">

   
  </head>
  <%
      ProductoDaoImpl dao = new ProductoDaoImpl();
      List<Producto> listProducto = new ArrayList();
      
   %>
  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.html">Alibaba</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Configuración</a></li>
            <li><a href="#">Usuario</a></li>
            <li><a href="#">Ayuda</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Buscar...">
          </form>
            
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="index.html">Inicio <span class="sr-only">(current)</span></a></li>
            <li><a href="reportes.jsp">Reportes</a></li>
            <li><a href="analisis.jsp">Analisis</a></li>
            <li><a href="usuarios.jsp">Usuarios</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="productos.jsp">Productos</a></li>
            <li><a href="categorias.jsp">Categorías</a></li>
            <li><a href="clientes.jsp">Clientes</a></li>
            <li><a href="ventas.html">Ventas</a></li>
            
          </ul>
          
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Productos</h1>

    
    <h4></h4>
          <div class="row placeholders">
              <div class="row">
                <div class="col-xs-6 col-sm-4"></div>
                <div class="col-xs-6 col-sm-4"></div>
                <div class="clearfix visible-xs-block"></div>
                <div class="col-xs-6 col-sm-4"><button type="button" class="btn btn-primary" onclick="window.location.href='registrar_producto.jsp'">Nuevo Producto</button></div>
              </div>
          
          </div>
          
<!-- Tabla productos -->
          <div class="panel panel-default">
              <div class="panel-heading">
                  <form class="form-inline">
                    <label class="sr-only" for="inlineFormCustomSelect">Parametro</label>
                    <select class="form-control" id="inlineFormCustomSelect">
                      <option selected>- Seleccione -</option>
                      <option value="1">Código</option>
                      <option value="2">Nombre</option>
                      <option value="3">Cantidad</option>
                      <option value="3">Categoría</option>
                      <option value="3">Estado</option>
                    </select>
                    <input type="text" class="form-control" id="inputBuscar" >
                    <button type="submit" class="btn btn-primary">Buscar</button>
                  </form>
              </div>
            <table class="table">
              <thead>
                <tr>
                  
                  <th>Código</th>
                  <th>Nombre</th>
                  <th>Cantidad</th>
                  <th>Categoría</th>
                  <th>Estado</th>
                  <th>Operaciones</th>
                </tr>
              </thead>
              <tbody>
                  <!-- fila inicial -->
                  <%
                      listProducto = dao.listar();
                      for(Producto p : listProducto){
                   %>
                <tr>
                    <td><%= p.getCodProducto() %></td>
                  <td><%= p.getNombre()%></td>
                  <td><%= p.getCantidad()%></td>
                  <td><%= p.getIdCategoria()%></td>
                  <td><%= p.getEstado()%></td>
                  <td>
                    <div class="row">
                        <div class="col-1 col-md-1">
                            
                             <form action="pruebasv" method="get">
                                <a href="javascript:;" onclick="parentNode.submit();" name="btnModificar">
                                <span class="glyphicon glyphicon-file"></span>
                                </a>
                             <input type="hidden" name="btnModificar" value="modificar"/>
                             <input type="hidden" name="codigo" value='<%= p.getIdProducto() %>'/>
                            </form> 
                        </div>
                        <div class="col-1 col-md-1">
                            <form action="pruebasv" method="get">
                                <a href="javascript:;" onclick="parentNode.submit();" name="btnEliminar">
                                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                </a>
                                <input type="hidden" name="btnEliminar" value="eliminar"/>
                                <input type="hidden" name="cod" value='<%= p.getIdProducto() %>'/>
                            </form>                  
                        </div>
                        <div class="col-1 col-md-1">
                            <a href="#" data-toggle="tooltip" data-placement="top" title="Modificar">
                                <span class="glyphicon glyphicon-check" aria-hidden="true"></span>
                            </a>
                        </div>
                   </div>
                  </td>
                </tr>
                <% } %>
                <!--  termina la fila inicial -->
              
               
                
              </tbody>
            </table>
          </div> <!-- termina la tabla productos -->

        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript -->

  </body>
</html>
       