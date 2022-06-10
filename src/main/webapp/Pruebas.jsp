<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
    </head>
    <c:if test="${valor != null}">
        <p>${valor}</p>
    </c:if>
        
    <form action="Instancias" method="POST">

        <div class="nombrePizza">
            <label for="nombre">Nombre Pizza: </label>
            <input type="text" name="nombre">
        </div>

        <div class="descripcion">
            <label for="descripcion">Descripcion: </label>
            <input type="text" name="descripcion">
        </div>


        <div class="precio">
            <label for="precio">Precio: </label>
            <input type="text" name="precio">
        </div>

        <input type="submit" name="accion" value="Crear Pizza">

    </form>


</html>