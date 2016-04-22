<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%
  String participants = request.getParameter("participants");
  int participants_int = Integer.parseInt(request.getParameter("participants"));
  String mod_name = request.getParameter("mod_name");
  String money = request.getParameter("money");
  String date = request.getParameter("date");
  String msg = request.getParameter("msg");
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
                                <h3>¡Muy bien! Ya tenemos todos los datos </h3>
                                <h3>Ahora es el momento de realizar el sorteo </h3>
                                <br />
                                <form method="get">
                                    <input type="hidden" name="participants" value='<%= participants %>'>
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
	                                <input type="hidden" name="mod_name" value='<%= mod_name %>'>
	                                <input type="hidden" name="money" value='<%= money %>'>
	                                <input type="hidden" name="date" value='<%= date %>'>
	                                <input type="hidden" name="msg" value='<%= msg %>'>
	                                <button onclick="this.form.action='logica_sorteo'" type="submit" class="btn btn-primary" style="margin-right:20px;">Realizar Sorteo</button>
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
