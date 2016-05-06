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
                                <p>Si todavía tienes dudas sobre cuál es el mejor regalo que puedes hacer, </br>
                                  es tu oportunidad para hablar con tu amigo invisible de forma completamente anónima. </br>
                                  Aquí tienes una lista de todos los grupos a los que estás unido:
                                 </p>
                                  <br />
                                 <div class="row">
                                <c:forEach items="${grupos}" var="grupo">
                                  <div class="col-md-12">
                                  	<form method="get" style= "display: inline;">
		                               <input type="hidden" name="grupo_id" value='${grupo.id}'>                                    
			                           <button onclick="this.form.action = 'conversacion';" type="submit" class="btn btn-default" style="margin: 0; padding: 0; background:transparent; border: none; color:#428bca">${grupo.nombre}</button>
	                                </form>
	                                <c:if test="${fn:contains(gruposnoleidos, grupo.id)}">
		                                <label for="exampleInput" ><div id= "popup" class= "popupHover" style= "display: inline; position: relative"><span class="glyphicon glyphicon-envelope"></span>
	                                     <div id="info" class="popupBox" style="z-index:1; top:20px; width: 150px;" align="left"> Tienes mensajes nuevos en este grupo. Click para consultar.</div></div></label>								
										
									</c:if>
                            </div>
                            <br />
                            </c:forEach>
                            </div>
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
