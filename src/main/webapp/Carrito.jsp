
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="WEB-INF/templates/header.jsp"/>

<main class="contenedor">
    <form action="Controlador" method="POST">
        
        <div class="trabajo">
            <div class="trabajo-new">
                <h3>Carrito Actual</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Titulo Pizza</th>
                            <th>Descripcion</th>
                            <th>Precio</th>
                            <th>Cantidad</th>
                        </tr>
                    </thead>
                    <tbody>
                    <div id="orden">
                        
                    </div>
                        <c:forEach items="${Carrito}" var="pizza" >
                            <tr>
                                <td>${pizza.nombre}</td>

                                <td>${pizza.descripcion}</td>
                                
                                <td>$${pizza.precio}</td>

                                <td><input type="number" name="${pizza.id}" min="1" value="1" ></td>

                                <td> <input type="hidden" value="${pizza.id}" name="id"> <input type="submit" name="accion" value="X"> </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <input type="submit" name="accion" value="Realizar Compra">
    </form>

    <div class="total">
        <h2>Total: $${Total}</h2>
    </div>
</main>
<script>
    const orden = document.querySelector("#orden");
    let inputText = '<input type="hidden" name="idOrden" value="'+Date.now()+'">';
    orden.innerHTML = inputText;
</script>
<jsp:include page="WEB-INF/templates/footer.jsp"/>