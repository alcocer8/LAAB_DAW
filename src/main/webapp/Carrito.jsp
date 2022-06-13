
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="WEB-INF/templates/header.jsp"/>

<main class="contenedor">
    <form action="ControladorCliente" method="POST">
        
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

                                <td> <a class="trash" href="ControladorCliente?accion=EliminarCarrito&idPizza=${pizza.id}">
                                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none"
                                         viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                    <path stroke-linecap="round" stroke-linejoin="round"
                                          d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16" />
                                    </svg>
                                </a> </td>
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