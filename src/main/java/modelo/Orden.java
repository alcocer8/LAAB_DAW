package modelo;

import java.io.Serializable;

public class Orden implements Serializable{
    
    private int idOrden;
    private int idUsuario;
    private int idPizza;
    private int cantidad;
    private String descripcion;

    public Orden() {
    }

    public Orden(int idOrden, int idUsuario, int idPizza, int cantidad, String descripcion) {
        this.idOrden = idOrden;
        this.idUsuario = idUsuario;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
        return "Orden{" + "idOrden=" + idOrden + ", idUsuario=" + idUsuario + ", idPizza=" + idPizza + ", cantidad=" + cantidad + ", descripcion=" + descripcion + '}';
    }
    
    
    
}
