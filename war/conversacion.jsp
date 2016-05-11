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
                                <p> Estos son tus chats en el grupo <c:out value="${grupo.nombre}" />. ¡Manda un mensaje a </br />
                                tu amigo invisible o al destinatario de tu regalo!
                                 </p>
                                  <br />
                                 <div class="row">
                                  <div class="col-md-6">
                                 	<p><u> ¡Chatea con quien te regala! </u> </p> <br />
                                 	<div class="scroll" style="height: 400px; overflow: auto; background-color: #F2F2F2; border: 3px solid #E6E6E6; word-wrap: break-word ">
                                 	<c:forEach items="${conver_invi}" var="msg">
	                                  <p style=" color: #2E9AFE; "> <c:out value="${msg}" /> </p> <br />
	                           		</c:forEach>
	                           		</div>                               	
                                 	<div class="form-group">
                                 	<form method="post">
                                 	 <input type="hidden" name="conver" value='invisible'>
                                 	 <input type="hidden" name="grupo_id" value='${grupo.id}'>
                                     <input type="text" class="form-control" required placeholder="Escribe un mensaje" name="conv_invi"><br/>
                                     <button type="submit" class="btn btn-default" onclick="this.form.action='/conversacion'"> Enviar </button>
                                   </form></div>                                   
                                 </div>
                                 
                                 <div class="col-md-6">
                                 	<p><u> ¡Chatea con quien recibe tu regalo: ${userto}! </u> </p> <br />
                                 	<div class="scroll" style="height: 400px; overflow: auto; background-color: #F2F2F2; border: 3px solid #E6E6E6; word-wrap: break-word">
                                 	<c:forEach items="${conver_vi}" var="msg">
	                                  <p style=" color: #2E9AFE;"> <c:out value="${msg}" /> </p> <br />
	                           		</c:forEach>
	                           		</div>
                                 	<div class="form-group">
                                 	<form method="post">
                                 	 <input type="hidden" name="conver" value='visible'>
                                 	 <input type="hidden" name="grupo_id" value='${grupo.id}'>
                                     <input type="text" class="form-control" required placeholder="Escribe un mensaje" name="conv_vi"><br/>
                                     <button type="submit" class="btn btn-default" onclick="this.form.action='/conversacion'"> Enviar </button>
                                   </form></div>                            
                                   </div>
                                   
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
