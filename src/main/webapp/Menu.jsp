
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/templates/header.jsp"/>

<main class="contenedor">
    <h2>Nuestros Productos</h2>


    <div class="grid-menu">
        <c:forEach var="pizza" items="${pizzas}">
            <form action="Controlador" method="POST">
                 <div class="card-pizza">
                <div class="img-pizza">
                    <img src="/img/2.jpg" alt="pizza-img">
                </div>
                    <input type="hidden" value="${pizza.id}" name="id">
                <div class="info-pizza">
                    <h4>${pizza.nombre}</h4>
                    <input type="hidden" value="${pizza.nombre}" name="nombre">
                    <p><span>Precio:</span> $${pizza.precio}</p>
                    <input type="hidden" value="${pizza.precio}" name="precio">
                    
                    <p><span>Descripcion: ${pizza.descripcion}</span></p>
                    <input type="hidden" value="${pizza.descripcion}" name="descripcion">
                </div>
                
                <input type="submit" value="Agregar Carrito"  name="accion" class="btn">
            </div>
            </form>
        </c:forEach>
    </div>
</main>

<jsp:include page="/WEB-INF/templates/footer.jsp"/>