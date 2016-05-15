<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
                <div class="row portfolio">
                    <div class="col-md-12">
                        <div class="block-top">
                            <div class="service-header">
                                <p> Por si eres un despistado aquí tienes los grupos a los que estás apuntado <br />
                                  ¡No olvides tampoco comprar el regalo antes de la fecha de entrega de regalos!
                               </p>
                               <br />
                               <div class="row">
                                <c:forEach items="${grupos}" var="grupo">
                                  <div class="col-md-6">
                                 	<p>${grupo.nombre} (${grupo.fecha}) Precio Max: (${grupo.preciomax})</p>
                                     <ul style="list-style:none; padding-left:0px; color:#AFB8B8;">
                                      <c:forEach items="${agrupaciones[grupo.id]}" var="agrupacion">
                                       <li>
                                       <c:out value="${agrupacion.user}"/>
                                       	<c:if test="${usuario.nick == grupo.moderador && agrupacion.user != usuario.nick && agrupacion.amigoinv == ''}">
	                                     	<form method="post" style= "display: inline;">
		                                     	<input type="hidden" name="grupo_id" value='${grupo.id}'>
		                                     	<input type="hidden" name="usuario" value='${agrupacion.user}'>
		                                     	<input type="hidden" name="lock" value="false">	                                     
			                                    <button onclick="this.form.action = 'Grupos';" type="submit" class="btn btn-default" style="margin: 0; padding: 0; background:transparent; border: none;"><span class="glyphicon glyphicon-minus-sign" style="color:red;"></span></button>
	                                    	</form>  
	                                   	</c:if>                                 
                                       </li>
                                      </c:forEach>
                                     </ul>
                                     <c:if test="${usuario.nick != grupo.moderador && agrupaciones[grupo.id][0].amigoinv == ''}">
	                                   	 <form method="post">
			                                     	<input type="hidden" name="grupo_id" value='${grupo.id}'>
			                                     	<input type="hidden" name="usuario" value='${usuario.nick}'>
			                                     	<input type="hidden" name="lock" value="false">		                                     
				                                    <button onclick="this.form.action = 'Grupos';" type="submit" class="btn btn-default"><span class="glyphicon glyphicon-minus-sign" style="color:red;"></span> Salir del grupo</button>
		                                 </form>
	                                 </c:if>
	                                 <c:if test="${usuario.nick == grupo.moderador}">
	                                   	 <form method="post">
			                                     	<input type="hidden" name="grupo_id" value='${grupo.id}'>			                                     	                                    
				                                    <button onclick="this.form.action = 'eliminar_grupo';" type="submit" class="btn btn-default"><span class="glyphicon glyphicon-minus-sign" style="color:red;"></span> Eliminar grupo</button>
		                                 </form>
		                                 <c:if test="${agrupaciones[grupo.id][0].amigoinv == ''}">
			                                 <form action="/Grupos" method="post">
	                                     		<input type="hidden" name="grupo_id" value='${grupo.id}'>
	                                     		<input type="hidden" name="lock" value="true">	
		                                    	<input type="text" required name="item" class="form-control" 
		                                    	style="width:150px; margin-left:auto; margin-right:auto;">
		                                   	 	<label style="font-size:1.1em;"> @gmail.com </label><br><br>
		                                    	<input type="submit" value="Añadir" 
		                                    	type="button" class="btn btn-default"/> 
	                              				<span class="glyphicon glyphicon-plus-sign"></span>
	                              			 </form>
	                              			 <form method="post">
	                                     		<input type="hidden" name="grupo_id" value='${grupo.id}'>	             
		                                    	<button onclick="this.form.action = 'logica_sorteo_grupos';" type="submit" class="btn btn-primary">Sortear</button>
	                              			 </form>    
	                              		</c:if>                          	
	                                 </c:if>                                 
                                  </div>                                 
                              	</c:forEach>                                
                               </div>
                               <br />
                               <br />
                               <button onclick="location.href='nuevo_grupo.jsp';" type="button" class="btn btn-primary">Nuevo Grupo</button>
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

