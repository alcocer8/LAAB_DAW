
package modelo;

import java.io.Serializable;

public class OrdenCliente implements Serializable{
    private String idOrden;
    private int idCliente;
    private int idPizza;
    private int cantidad;
    private int idEstado;
    private String nombrePizza;
    private String estado;
    private String nombreCliente;
    private String apellidoCliente;
    private String telefono;
    private String email;

    public OrdenCliente() {
    }

    public OrdenCliente(String idOrden, int idCliente, int idPizza, int cantidad, int idEstado, String nombrePizza, String estado, String nombreCliente, String apellidoCliente, String telefono, String email) {
        this.idOrden = idOrden;
        this.idCliente = idCliente;
        this.idPizza = idPizza;
        this.cantidad = cantidad;
        this.idEstado = idEstado;
        this.nombrePizza = nombrePizza;
        this.estado = estado;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.telefono = telefono;
        this.email = email;
    }

    public String getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(String idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombrePizza() {
        return nombrePizza;
    }

    public void setNombrePizza(String nombrePizza) {
        this.nombrePizza = nombrePizza;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "OrdenCliente{" + "idOrden=" + idOrden + ", idCliente=" + idCliente + ", idPizza=" + idPizza + ", cantidad=" + cantidad + ", idEstado=" + idEstado + ", nombrePizza=" + nombrePizza + ", estado=" + estado + ", nombreCliente=" + nombreCliente + ", apellidoCliente=" + apellidoCliente + ", telefono=" + telefono + ", email=" + email + '}';
    }
    
}
