
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="src/styles/style.css">
        <link rel="stylesheet" href="src/styles/normalize.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Akshar:wght@400;700&display=swap" rel="stylesheet"> 
        <title>JAVA_WEB</title>
    </head>
    <body>
        <header>
            <nav class="nav-bar">
                <a href="index.jsp">
                    <h1>Lencho Pizza</h1>
                </a>
                <div class="enlaces">
                    <a href="Controlador?accion=Menu">Menu</a>
                    <c:if test="${clienteSesion == null && empleadoSesion == null}">
                        <a href="Controlador?accion=Ingresar">Ingresar</a>
                    </c:if>

                    <c:if test="${clienteSesion != null}">
                        <a href="Controlador?accion=Carrito">Carrito</a>
                        <a href="Controlador?accion=SalirUsuario">Salir</a>
                    </c:if>

                    <c:if test="${empleadoSesion != null}">
                        <a href="Controlador?accion=dashboard">Control</a>
                        <a href="Controlador?accion=SalirUsuario">Salir</a>
                    </c:if>

                </div>
            </nav>
        </header>