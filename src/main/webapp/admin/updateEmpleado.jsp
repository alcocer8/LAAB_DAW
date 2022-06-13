<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../WEB-INF/templates/header.jsp"/>


<main class="contenedor">
    <div>
        <c:if test="${Empleado == null}" >
            <%response.sendRedirect("index.jsp");%>
        </c:if>

        <c:if test="${valor != null}" >
            <h2>${valor}</h2>
        </c:if>
    </div>

    <c:if test="${EmpleadoE == null}">
        <form action="ControladorEmpleado" method="POST" class="selecion-pizza">
            <select name="empleado">
                <c:forEach items="${empleados}" var="empleado">
                    <option value="${empleado.id}">${empleado.nombre} - ${empleado.usuario}</option>
                </c:forEach>
            </select>

            <input type="submit" name="accion" value="Seleccionar Empleado" class="btn">
        </form>
    </c:if>

    <c:if test="${EmpleadoE != null}">
        <form action="ControladorEmpleado" method="POST">
            <div class="campos">

                <input type="hidden" name="id" value="${EmpleadoE.id}">

                <div class="campo">
                    <label for="nombre">Nombre: </label>
                    <input type="text" id="nombre" name="nombre" value="${EmpleadoE.nombre}">
                </div>
                
                <div class="campo">                    
                    <label for="apellido">Apellido: </label>
                    <input type="text" id="apellido" name="apellido" value="${EmpleadoE.apellido}">
                </div>
                
                <div class="campo">                    
                    <label for="usuario">Usuario: </label>
                    <input type="text" id="usuario" name="usuario" value="${EmpleadoE.usuario}">
                </div>
                
                <div class="campo">                    
                    <label for="password">Password: </label>
                    <input type="password" id="password" name="password" value="${EmpleadoE.password}">
                </div>
                
                <div class="campo">
                <label for="puesto">Puesto:</label>
                <select name="puesto" id="puesto">
                    <option value="0" selected disabled>--Seleciona--</option>
                    <option value="1">Administrador</option>
                    <option value="2">Empleado</option>
                </select>
            </div>
                
                <input type="submit" value="Actualizar Empleado" name="accion" class="btn">
                <input type="submit" value="Eliminar Empleado" name="accion" class="btn">
            </div>

        </form>
    </c:if>
</main>
<jsp:include page="../WEB-INF/templates/footer.jsp"/>