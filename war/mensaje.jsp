<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%
  String participants = request.getParameter("participants");
  int participants_int = Integer.parseInt(request.getParameter("participants"));
  String[] usernames = new String[participants_int];
  String[] emails = new String[participants_int];
  String[] excls = new String[participants_int];
  for(int i=1; i<=participants_int; i++) {
	  usernames[i-1] = request.getParameter("username"+i);
	  emails[i-1] = request.getParameter("email"+i);
	  excls[i-1] = request.getParameter("excl"+i);
  }
%>

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
                  <img src="img/logo.png" alt="logo">
                  </div>
								</div>

								<!-- Collect the nav links, forms, and other content for toggling -->
								<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                  <ul class="nav navbar-nav">
                  <li><a href="index.jsp">Inicio</a></li>
                  <li><a href="participantes.jsp">Participantes</a></li>
                  <li class="active"><a href="mensaje.jsp">Mensaje <span class="sr-only">(current)</span></a></li>
                  </ul>
								  <ul class="nav navbar-nav dcha">
                  				<c:if test="${not empty pageContext.request.userPrincipal}">
								    <li><a href="/Login"/>Cerrar Sesión</a></li>
								</c:if>
								<c:if test="${empty pageContext.request.userPrincipal}">
								    <li><a href="/Login"/>Iniciar Sesión</a></li>
								</c:if>
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
                              <form method="post">
                              <%
                                  String username;
								  String email;
								  String excl;
	                              for(int i=1; i<=participants_int; i++) { 
	                              	username = "username"+i;
	                              	email = "email"+i;
	                              	excl = "excl"+i;
	                              %>
	                            	  <input type="hidden" name='<%= username %>' value='<%= usernames[i-1] %>'>
	                                  <input type="hidden" name='<%= email %>' value='<%= emails[i-1] %>'>
	                                  <input type="hidden" name='<%= excl %>' value='<%= excls[i-1] %>'>
	                              <% }
                              %>
                              <input type="hidden" name="participants" value='<%= participants %>'>
                                <div class="form-group" style="max-width:600px; margin-left:auto; margin-right:auto;">
                                  <label for="exampleInputName">¿Quién es el organizador del sorteo?</label>
                                  <input type="text" class="form-control" id="exampleInputName" name="mod_name">
                                </div>
                                <div class="form-group" style="max-width:600px; margin-left:auto; margin-right:auto;">
                                  <label for="exampleInputMoney">Define la cuantía máxima de los regalos:</label>
                                  <input type="text" class="form-control" id="exampleInputMoney" name="money">
                                </div>
                                <div class="form-group" style="max-width:600px; margin-left:auto; margin-right:auto;">
                                  <label for="exampleInputDate">Elige el día en el que se repartirán los regalos:
                                  <span class="glyphicon glyphicon-calendar"></span></label>
                                  <input type="text" class="form-control" id="exampleInputDate" name="date">
                                </div>
                                <div class="form-group" style="max-width:600px; margin-left:auto; margin-right:auto;">
                                  <label for="exampleInputMessage">Escribe el mensaje que recibiréis:</label>
                                  <input type="text" class="form-control" id="exampleInputMessage" name="msg">
                                </div>
                                <br />
                                <div class="row">
                                  <div class="col-md-6">
                                    <button type="submit" class="btn btn-default" onclick="this.form.action='participantes.jsp'"><span class="glyphicon glyphicon-circle-arrow-left"></span> Anterior</button>
                                  </div>
                                  <div class="col-md-6">
                                    <button type="submit" class="btn btn-default" onclick="this.form.action='sortear.jsp'">Siguiente <span class="glyphicon glyphicon-circle-arrow-right"></span></button>
                                  </div>
                                </div>
                              </form>
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
