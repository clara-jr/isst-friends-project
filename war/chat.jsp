<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <section id="header">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="block-left">
							<nav class="navbar navbar-default" role="navigation">
							  <div class="container-fluid">
								<!-- Brand and toggle get grouped for better mobile display -->
								<div class="navbar-header">
								  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
									<span class="sr-only">Toggle navigation</span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
								  </button>
                  <div class="nav-logo">
                  <a href="#"><img src="img/logo.png" alt="logo"></a>
                  </div>
								</div>

								<!-- Collect the nav links, forms, and other content for toggling -->
								<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                  <ul class="nav navbar-nav">
                  <li><a href="grupos.jsp">Mis Grupos</a></li>
                  <li><a href="deseos.jsp">Mis Deseos</a></li>
                  <li><a href="amigos.jsp">Mis Amigos</a></li>
                  <li class="active"><a href="chat.jsp">Chat <span class="sr-only">(current)</span></a></li>
                  </ul>
								  <ul class="nav navbar-nav dcha">
                  <li><a href="<c:url value="${url}"/>"><c:out value="${urlLinktext}"/></a></li>
                  </ul>
								</div><!-- /.navbar-collapse -->
							  </div><!-- /.container-fluid -->

							</nav>
                        </div>
                    </div><!-- .col-md-6 -->

                </div><!-- .row close -->
            </div><!-- .container close -->
        </section><!-- #heder close -->

        <!-- Service Start
        ============================================================= -->

        <section id="service">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="block-top">
                            <div class="service-header">
                                <p>Si todavía tienes dudas sobre cuál es el mejor regalo que puedes hacer, </br>
                                  es tu oportunidad para hablar con tu amigo invisible de forma completamente anónima </br>
                                 </p>
                                  <br />
                                 <ul style="list-style:none; padding-left:0px; color:#AFB8B8;">
                                   <li><a href="chat.jsp"><span class="glyphicon glyphicon-envelope"></span> Chatear con Cristina</a></li> <br />
                                   <li><a href="chat.jsp"><span class="glyphicon glyphicon-envelope"></span> Chatear con Pablo</a></li> <br />
                                   <li><a href="chat.jsp"><span class="glyphicon glyphicon-envelope"></span> Chatear con Rocío</a></li> <br />
                                   <li><a href="chat.jsp"><span class="glyphicon glyphicon-envelope"></span> Chatear con José Manuel</a></li>
                                 </ul>
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
