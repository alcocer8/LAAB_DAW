<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="/WEB-INF/templates/header.jsp" />

    <main class="contenedor">

        <c:if test="${PizzaE == null}">
            <form action="Controlador" method="POST" class="selecion-pizza">
                <select name="pizza">
                    <c:forEach items="${pizzas}" var="pizza">
                        <option value="${pizza.id}">${pizza.id}. ${pizza.nombre}</option>
                    </c:forEach>
                </select>

                <input type="submit" name="accion" value="Seleccionar Pizza" class="btn">
            </form>
        </c:if>

        <c:if test="${PizzaE != null}">
            <form action="Controlador" method="POST">
                <div class="campos">

                    <input type="hidden" name="id" value="${PizzaE.id}">

                    <div class="campo">
                        <label for="pizza">Nombre pizza: </label>
                        <input type="text" id="pizza" name="pizza" value="${PizzaE.nombre}">
                    </div>

                    <div class="campo">
                        <label for="precio">Precio pizza:</label>
                        <input type="text" id="precio" name="precio" value="${PizzaE.precio}">
                    </div>

                    <div class="campo">
                        <label for="descripcion">Descripcion: </label>
                        <textarea id="descripcion" name="descripcion" rows="5" cols="50"
                            style="text-align: center;">${PizzaE.descripcion}</textarea>
                    </div>

                    <input type="submit" value="Actualizar Pizza" name="accion" class="btn">
                </div>

            </form>
        </c:if>
    </main>


    <jsp:include page="/WEB-INF/templates/footer.jsp" />