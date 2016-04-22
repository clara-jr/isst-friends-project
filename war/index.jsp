<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->

<html>
  <head>
  	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Amigo Invisible</title>

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->

    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100,300,700,600,500' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Droid+Serif:400,400italic,700' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/responsive.css">
  </head>

  <body>
        <%@include file="marco.jsp" %>

        <!-- Service Start
        ============================================================= -->

        <section id="service">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="block-top">
                            <div class="service-header">
                                <h3> Te ayudamos a realizar el sorteo para el amigo invisible</h3>
                                <br />
                                <p> Nunca fue tan fácil realizar un sorteo entre amigos y acertar en el regalo <br />
                                Podéis realizar un sorteo básico recibiendo el resultado en vuestras <br />
                                direcciones de correo electrónico o pasar a formar parte de esta plataforma y gozar de <br />
                                un sinfín de posibilidades (gestión de grupos, listas de deseos, chat, etc)
                               </p>
                               <br />
                               <h3> ¿Qué decides? ¡Anímate! </h3>
                               <br />
                               <br />
                               <button onclick="location.href='participantes.jsp';" type="button" class="btn btn-primary" style="margin-right:20px;">Sorteo Básico</button>
                               <button onclick="location.href='/Login';" type="button" class="btn btn-primary" style="margin-left:20px;">Registrarse</button>
                            </div>
                        </div>
                    </div><!-- .col-md-12 close -->
                </div><!-- row close -->
            </div><!-- .container close -->
        </section><!-- #service close -->

        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
  </body>
</html>
