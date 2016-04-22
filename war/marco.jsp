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
                  <c:set var="URL" scope="session" value="${pageContext.request.requestURI}"/>
                  
                  <!-- Si el usuario está logueado -->
                  <c:if test="${not empty pageContext.request.userPrincipal}">
	                  
	                  <c:if test = "${URL == '/grupos.jsp' || URL == '/nuevo_grupo.jsp'}">
		                  <li class="active"><a href="/Grupos">Mis Grupos <span class="sr-only">(current)</span></a></li>
		              </c:if>
		              <c:if test = "${URL != '/grupos.jsp' && URL != '/nuevo_grupo.jsp'}">
		                  <li><a href="/Grupos">Mis Grupos </a></li>
		              </c:if>
		              
		              <c:if test = "${URL == '/deseos.jsp'}">
		                  <li class="active"><a href="/listas_deseos">Mis Deseos <span class="sr-only">(current)</span></a></li>
		              </c:if>
		              <c:if test = "${URL != '/deseos.jsp'}">
		                  <li><a href="/listas_deseos">Mis Deseos</a></li>
		              </c:if>
		              
		              <c:if test = "${URL == '/amigos.jsp'}">
		                  <li class="active"><a href="amigos.jsp">Mis Amigos <span class="sr-only">(current)</span></a></li>
		              </c:if>
		              <c:if test = "${URL != '/amigos.jsp'}">
		                  <li><a href="amigos.jsp">Mis Amigos</a></li>
		              </c:if>
		              
		              <c:if test = "${URL == '/chat.jsp'}">
		                  <li class="active"><a href="chat.jsp">Chat <span class="sr-only">(current)</span></a></li>
		              </c:if>
		              <c:if test = "${URL != '/chat.jsp'}">
		                  <li><a href="chat.jsp">Chat</a></li>
		              </c:if>
		            
	              </c:if>
	              
	              <!-- Si el usuario NO está logueado -->
	              <c:if test="${empty pageContext.request.userPrincipal}">
	              
		              <li><a href="index.jsp">Inicio</a></li>
		              
		              <c:if test = "${URL == '/participantes.jsp' || URL == '/mensaje.jsp' || URL == '/sortear.jsp'}">		              
		                <c:if test = "${URL == '/participantes.jsp'}">
		                	<li class="active"><a href="participantes.jsp">Participantes <span class="sr-only">(current)</span></a></li>
		                </c:if>
		                <c:if test = "${URL != '/participantes.jsp'}">
		               		<li><a href="participantes.jsp">Participantes</a></li>
		                </c:if>		                
		              </c:if>
		              
		              <c:if test = "${URL == '/mensaje.jsp' || URL == '/sortear.jsp'}">
		              	<c:if test = "${URL == '/mensaje.jsp'}">
		                	<li class="active"><a href="mensaje.jsp">Mensaje <span class="sr-only">(current)</span></a></li>
		                </c:if>
		                <c:if test = "${URL != '/mensaje.jsp'}">               
	                  		<li><a href="mensaje.jsp">Mensaje</a></li>
	                  	</c:if>
	                  </c:if>	                  
	                  <c:if test = "${URL == '/sortear.jsp'}">
	                  <li class="active"><a href="sortear.jsp">¡A Jugar! <span class="sr-only">(current)</span></a></li>
            		  </c:if>
            		</c:if>                 
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