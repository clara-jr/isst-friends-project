<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
  <head>
  	<meta http-equiv="content-type" content="text/html; charset=UTF-8">

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
                              <p>Error:</p>
                                <c:out value="${error}" />                             
                              <br /><br />
                              
                              <c:if test = "${error == '¡Ese deseo ya está en la lista!'}">
                                <form action ="/listas_deseos" method="get">
                              	<input type="submit" value="Volver"
                              	 type="button" class="btn btn-default"/> 
                              	</form>             
		              		  </c:if>
		              		  
		              		  <c:if test = "${error == '¡Ese usuario no existe!' || error == '¡Ese usuario ya está en el grupo!'}">
                                <form action ="/Grupos" method="get">
                              	<input type="submit" value="Volver"
                              	 type="button" class="btn btn-default"/> 
                              	</form>             
		              		  </c:if>
		              		  
		              		  <c:if test = "${error == '¡Has introducido un valor no numérico en el campo de exclusiones!'
		              		   || error == '¡Algún número en exclusiones es inválido!'}">
                                <form action ="/Grupos" method="get">
                              	<input type="submit" value="Volver"
                              	 type="button" class="btn btn-default"/> 
                              	</form>             
		              		  </c:if>
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
