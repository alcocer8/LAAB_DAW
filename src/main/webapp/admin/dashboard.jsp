<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/templates/header.jsp"/>

<main class="contenedor">
    <nav class="bar-admin">
        <a href="Controlador?accion=AgregarPizza" class="btn">Agregar Producto</a>
        <a href="Controlador?accion=ActualizarProductos" class="btn">Actualizar Pizzas</a>
        <a href="Controlador?accion=CrearEmpleado" class="btn">Crear Empleado</a>

    </nav>



    <h2>Hola usuario, Buen dia</h2>
    <div class="trabajo">
        <div class="trabajo-new">
            <h3>Trabajos Nuevos</h3>
            <table>
                <thead>
                    <tr>
                        <th>No. Order</th>
                        <th>Estado</th>
                        <th>Descripcion</th>
                        <th>Cliente</th>
                        <th>Contacto</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${Nuevo}" var="orden">
                        <tr>
                            <td>${orden.idOrden}</td>
                            <td>${orden.estado}</td>
                            <td>${orden.nombrePizza}</td>
                            <td>${orden.nombreCliente} ${orden.apellidoCliente}</td>
                            <td>
                                <p><span>Cel:</span> ${orden.telefono}</p>
                                <p><span>Email:</span> ${orden.email}</p>
                            </td>
                            <td>
                                <button class="trash"><svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none"
                                                           viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                    <path stroke-linecap="round" stroke-linejoin="round"
                                          d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16" />
                                    </svg></button>
                                <button class="check"><svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M14 5l7 7m0 0l-7 7m7-7H3" />
                                    </svg></button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="trabajo-prog">
            <h3>Trabajos en curso</h3>
            <table>
                <thead>
                    <tr>
                        <th>No. Order</th>
                        <th>Estado</th>
                        <th>Descripcion</th>
                        <th>Tiempo</th>
                        <th>Cliente</th>
                        <th>Contacto</th>

                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>En Curso</td>
                        <td>Pizza con todo</td>
                        <td>00:00</td>
                        <td>Lorenzo Alcocer</td>
                        <td>
                            <p><span>Cel:</span> 2211334455</p>
                            <p><span>Email:</span> lorenzo@correo.com</p>
                        </td>
                        <td>
                            <button class="trash"><svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none"
                                                       viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                <path stroke-linecap="round" stroke-linejoin="round"
                                      d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16" />
                                </svg></button>
                            <button class="check"><svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none"
                                                       viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                <path stroke-linecap="round" stroke-linejoin="round"
                                      d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z" />
                                </svg></button>
                        </td>
                    </tr>

                    <tr>
                        <td>1</td>
                        <td>En Curso</td>
                        <td>Pizza con todo</td>
                        <td>00:00</td>
                        <td>Lorenzo Alcocer</td>
                        <td>
                            <p><span>Cel:</span> 2211334455</p>
                            <p><span>Email:</span> lorenzo@correo.com</p>
                        </td>
                        <td>
                            <button class="trash"><svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none"
                                                       viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                <path stroke-linecap="round" stroke-linejoin="round"
                                      d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16" />
                                </svg></button>
                            <button class="check"><svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none"
                                                       viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                <path stroke-linecap="round" stroke-linejoin="round"
                                      d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z" />
                                </svg></button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

</main>


<jsp:include page="/WEB-INF/templates/footer.jsp"/>