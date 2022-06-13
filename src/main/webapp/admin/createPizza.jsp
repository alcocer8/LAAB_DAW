<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../WEB-INF/templates/header.jsp" />


<main class="contenedor">

    <div>
        <c:if test="${Empleado == null}">
            <%response.sendRedirect("index.jsp");%>
        </c:if>

        <c:if  test="${valor != null}" >
            <h2>${valor}</h2>
        </c:if>
    </div>

    <form action="ControladorEmpleado" method="POST">

        <div class="campos">

            <div class="campo">
                <label for="pizza">Nombre pizza: </label>
                <input type="text" id="pizza" name="pizza">
            </div>

            <div class="campo">
                <label for="precio">Precio pizza:</label>
                <input type="number" id="precio" name="precio">
            </div>

            <div class="campo">
                <label for="descripcion">Descripcion: </label>
                <textarea id="descripcion" name="descripcion" rows="5" cols="50" style="text-align: center;"></textarea>
            </div>

            <div class="campo">
                <label for="imagen">Imagen: </label>
                <input type="file" name="imagen">
            </div>


            <input type="submit" value="Crear Pizza" name="accion" class="btn">
        </div>

    </form>
</main>

<jsp:include page="../WEB-INF/templates/footer.jsp" />