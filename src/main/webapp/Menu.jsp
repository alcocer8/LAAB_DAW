
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/templates/header.jsp"/>

<main class="contenedor">
    <h2>Nuestros Productos</h2>


    <div class="grid-menu">
        <c:forEach var="pizza" items="${pizzas}">
            <div class="card-pizza">
                <div class="img-pizza">
                    <img src="src/img/1.jpg" alt="pizza-img">
                </div>
                    
                <div class="info-pizza">
                    <h4>${pizza.nombre}</h4>
                    <p><span>Precio:</span> $${pizza.precio}</p>
                    <p><span>Descripcion: ${pizza.descripcion}</span></p>
                </div>
                <div class="btn-menu">
                    <a class="btn" href="ControladorCliente?accion=AgregarCarrito&idPizza=${pizza.id}" >Agregar Carrito</a>
                </div>
            </div>
        </c:forEach>
    </div>
</main>

<jsp:include page="/WEB-INF/templates/footer.jsp"/>