
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<footer>
    <nav class="nav-footer">
        <div class="info">
            <div class="social">
                <p>FB</p>
                <p>Insta</p>
                <p>Celular</p>
            </div>

        </div>
        <div class="info">
            <a href="index.html">
                <h1>Lencho Pizza</h1>
            </a>
            <c:if test="${Empleado != null}">
                <a href="Controlador?accion=Empleado">¿Empleado?</a>
            </c:if>
        </div>
    </nav>
</footer>
</body>
</html>
