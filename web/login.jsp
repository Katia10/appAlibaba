<%-- 
    Document   : login.jsp
    Created on : 9/08/2017, 03:59:51 PM
    Author     : Estudiante
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="css/estilorcn.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">

        <form action="usuarioSvl" class="form-signin" method="get">
        <h2 class="form-signin-heading">Iniciar sesión</h2>
        <label for="inputEmail" class="sr-only">Usuario</label>
        <input type="text" name="usuario" class="form-control" placeholder="Usuario" required autofocus>
        <label for="inputPassword" class="sr-only">contraseña</label><br>
        <input type="password" name="pass" class="form-control" placeholder="Contraseña" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Recordar contraseña
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="btnLogin" value="acceder">Ingresar</button>
      </form>
        <br>
        <%
            if(request.getAttribute("respuesta")!=null) {
                %>
                <div class="alert alert-info" role="alert">
                <%out.println(" " + request.getAttribute("respuesta"));%>
                 </div>
            <%
                }
           
            %>
    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
