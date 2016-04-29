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
                                <p> Estos son tus chats en este grupo. ¡Manda un mensaje a </br />
                                tu amigo invisible o al destinatario de tu regalo!
                                 </p>
                                  <br />
                                 <div class="row">
                                  <div class="col-md-6">
                                 	<p><u> ¡Chatea con quien te regala! </u> </p> <br />
                                 	<p> TODO: Mostrar esta conversación </p> <br />                               	
                                 	<div class="form-group">
                                 	<form method="post">
                                     <input type="text" class="form-control" required placeholder="Escribe un mensaje" name="conv1"><br/>
                                     <button type="submit" class="btn btn-default" onclick="this.form.action='/conversacion'"> Enviar </button>
                                   </form></div>                                   
                                 </div>
                                 
                                 <div class="col-md-6">
                                 	<p><u> ¡Chatea con quien recibe tu regalo! </u> </p> <br />
                                 	<p> TODO: Mostrar esta conversación </p> <br />
                                 	<div class="form-group">
                                 	<form method="post">
                                     <input type="text" class="form-control" required placeholder="Escribe un mensaje" name="conv2"><br/>
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
