<%-- 
    Document   : registrar_productos.jsp
    Created on : 17/07/2017, 09:58:52 PM
    Author     : toshiba
--%>

<%@page import="com.proyecto.dao.ProductoDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
   
    <meta name="viewport" content="width=device-width, initial-scale=1">
 
   

    <title>Dashboard - Sistema de Gestión</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

   
    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">

   
  </head>
        <% 
            ProductoDaoImpl dao = new ProductoDaoImpl();
            String codigo =  dao.generarCodigo();
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

            <div class="row placeholders">
                <div class="row">
                  <div class="col-xs-6 col-sm-4"></div>
                  <div class="col-xs-6 col-sm-4"></div>
                  <div class="clearfix visible-xs-block"></div>
                  <div class="col-xs-6 col-sm-4"><button type="button" class="btn btn-primary" onclick="window.location.href='productos.jsp'">Regresar</button></div>
                </div>

            </div>

  
          <div class="row justify-content-md-center">
            <div class="col-2 col-lg-3">

            </div>
<!-- Inicia el formulario -->              
<form action="pruebasv" method="post">
            <div class="col-6 col-lg-6">
                 <fieldset disabled>
              <div class="form-group row">
                <label for="example-text-input" class="col-2 col-form-label">Código del Producto</label>
                <div class="col-10">
                    <input class="form-control" type="text" placeholder="Código" value='<%= codigo %>' >
                </div>
                
              </div>
                 </fieldset>
                <input type="hidden" name="codigo" value='<%= codigo %>' readonly="readonly" />
              <div class="form-group row">
                <label for="example-text-input" class="col-2 col-form-label">Nombre del Producto</label>
                <div class="col-10">
                    <input class="form-control" type="text" placeholder="Nombre" id="nombreProducto" name="nombre" required="Ingrese nombre">
                </div>
              </div>
              <div class="form-group row">
                <label for="example-number-input" class="col-2 col-form-label">Precio de compra</label>
                <div class="col-10">
                    <input class="form-control" type="number" placeholder="00.00" id="precioCompra" name="compra" required="Ingrese el precio">
                </div>
                  </div>
                  <div class="form-group row">
                    <label for="example-number-input" class="col-2 col-form-label">Precio de venta</label>
                    <div class="col-10">
                        <input class="form-control" type="number" placeholder="00.00" id="precioVenta" name="venta" required="Ingrese el precio">
                    </div>
                  </div>
                  <div class="form-group row">
                    <label for="example-number-input" class="col-2 col-form-label">Cantidad</label>
                    <div class="col-10">
                        <input class="form-control" type="number" placeholder="00" id="precioVenta" name="cantidad" required="Ingrese cantidad">
                    </div>
                  </div>

                
                  <div class="form-group row">
                    <label for="example-categoria-select" class="col-2 col-form-label">Categoría</label>
                    <div class="col-10">
                      <select class="form-control" name="categoria">
                        <option selected>Seleccione la categoría</option>
                        <option value="1">Lácteos</option>
                        <option value="2">Producto de Limpieza</option>
                        <option value="3">Producto de Limpieza</option>
                        <option value="4">Línea Blanca</option>
                      </select>   
                    </div>
                  </div>
                
                <fieldset disabled>
                    <div class="form-group row">
                      <label for="example-text-input" class="col-2 col-form-label">Estado</label>
                      <div class="col-10">
                          <input class="form-control" type="text" name="estados" value="Activo" id="codigoProducto" >
                          
                      </div>
                    </div>
                    </fieldset>
                <input type="hidden" name="estado" value="Activo" readonly="readonly" />
                <div class="form-group row">
                    <button type="submit" class="btn btn-primary" name="btnRegistrar" value="Registrar">Registrar</button>
                </div>
                  </div>
                  </form>
<!-- termina el formulario -->
                  <div class="col-3 col-lg-3">
                        
                  </div>
        </div>


        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript -->

  </body>
</html>
       