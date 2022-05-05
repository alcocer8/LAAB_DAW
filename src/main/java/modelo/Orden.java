package modelo;

import java.io.Serializable;

public class Orden implements Serializable{
    
    private int idOrden;
    private int idCliente;
    private int idPizza;
    private int cantidad;
    private String descripcion;

    public Orden() {
    }

    public Orden(int idOrden, int idCliente, int idPizza, int cantidad, String descripcion) {
        this.idOrden = idOrden;
        this.idCliente = idCliente;
        this.idPizza = idPizza;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Orden{" + "idOrden=" + idOrden + ", idCliente=" + idCliente + ", idPizza=" + idPizza + ", cantidad=" + cantidad + ", descripcion=" + descripcion + '}';
    }
    
    
    
}
