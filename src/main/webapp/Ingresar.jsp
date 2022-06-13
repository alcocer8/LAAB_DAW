<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/templates/header.jsp"/>

<main class="contenedor">
    <c:if test="${valor != null}">
        <h2>${valor}</h2>
    </c:if>
    
    <h2>Ingresar</h2>

    <div class="form">
        <form action="ControladorUsuarios" method="POST" class="login">
            <div class="campos">

                <svg viewBox="0 0 15 15" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" clip-rule="evenodd"
                          d="M2.5 1C1.67157 1 1 1.67157 1 2.5V5H0V2.5C0 1.11929 1.11929 0 2.5 0H5V1H2.5ZM12.5 1H10V0H12.5C13.8807 0 15 1.11929 15 2.5V5H14V2.5C14 1.67157 13.3284 1 12.5 1ZM5 6H4V5H5V6ZM11 6H10V5H11V6ZM4.9 8.7C6.2 10.4333 8.8 10.4333 10.1 8.7L10.9 9.3C9.2 11.5667 5.8 11.5667 4.1 9.3L4.9 8.7ZM0 12.5V10H1V12.5C1 13.3284 1.67157 14 2.5 14H5V15H2.5C1.11929 15 0 13.8807 0 12.5ZM15 10V12.5C15 13.8807 13.8807 15 12.5 15H10V14H12.5C13.3284 14 14 13.3284 14 12.5V10H15Z"
                          fill="black" />
                </svg>

                <div class="campo">
                    <label for="email">Usuario</label>
                    <input type="email" id="email" name="email">
                </div>

                <div class="campo">
                    <label for="pass">Contraseña</label>
                    <input type="password" id="pass" name="pass">
                </div>
                <a href="ControladorUsuarios?accion=Registro" class="registro">¿Eres Nuevo Usuario? Registrate</a>

                <input type="submit" value="Ingresar Cliente" name="accion" class="btn">
            </div>

        </form>
    </div>
</main>

<jsp:include page="/WEB-INF/templates/footer.jsp"/>