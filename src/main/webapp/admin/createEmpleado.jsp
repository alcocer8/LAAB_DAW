<jsp:include page="../WEB-INF/templates/header.jsp"/>

<main class="contenedor">
    <form action="Controlador" method="POST">
        <div class="campos">

            <div class="campo">
                <label for="nombre">Nombre: </label>
                <input type="text" id="nombre" name="nombre">
            </div>

            <div class="campo">
                <label for="apellido">Apellido:</label>
                <input type="text" id="apellido" name="apellido">
            </div>

            <div class="campo">
                <label for="usuario">Usuario:</label>
                <input type="text" id="usuario" name="usuario" value="Emp${lastId}">
            </div>
            
            <div class="campo">
                <label for="precio">Password:</label>
                <input type="password" id="pass" name="pass">
            </div>
            
            <div class="campo">
                <label for="puesto">Puesto:</label>
                <select name="puesto" id="puesto">
                    <option value="" selected disabled>--Seleciona--</option>
                    <option value="1">Administrador</option>
                    <option value="2">Empleado</option>
                </select>
            </div>

            <input type="submit" value="Crear Empleado" name="accion" class="btn">
        </div>

    </form>
</main>
<jsp:include page="../WEB-INF/templates/footer.jsp"/>