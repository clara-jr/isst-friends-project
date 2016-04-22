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
        <%@include file="marco.jsp" %>

        <!-- Service Start
        ============================================================= -->

        <section id="service">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="block-top">
                            <div class="service-header">
                              <p>Añade deseos a tu lista para que tu amigo invisible acierte con el regalo!</p>
                              <br />
                              <ul style="list-style:none; padding-left:0px; color:#AFB8B8;">
                                <c:forEach items="${deseos}" var="deseo">
                                <li><c:out value="${deseo.item}" /> <form method="post" style= "display: inline;">
		                                     	<input type="hidden" name="lock" value="false">
		                                     	<input type="hidden" name="item" value='${deseo.item}'>	                                     
			                                    <button onclick="this.form.action = 'listas_deseos';" type="submit" class="btn btn-default" style="margin: 0; padding: 0; background:transparent; border: none;"><span class="glyphicon glyphicon-minus-sign" style="color:red;"></span></button>
	                                    	</form>  </li>
                                </c:forEach>
                              </ul>
                              <br />
                                <form action ="/listas_deseos" method="post">
                                <input type="text" required name ="item" class="form-control" 
                                style="width:150px; margin-left:auto; margin-right:auto;">
                                <br>
                                <input type="hidden" name="lock" value="true"/>
                              	<input type="submit" value="Añadir deseo"
                              	 type="button" class="btn btn-default"/> 
                              	<span class="glyphicon glyphicon-plus-sign"></span>
                              	</form>             
                              <br />
                              <c:out value="${user}" />
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
