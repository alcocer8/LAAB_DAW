package modelo;

import java.io.Serializable;

public class Orden implements Serializable{
    
    private String idOrden;
    private int idCliente;
    private int idPizza;
    private int cantidad;
    private int idEstado;
    

    public Orden() {
    }

    public Orden(String idOrden, int idCliente, int idPizza, int cantidad, int idEstado) {
        this.idOrden = idOrden;
        this.idCliente = idCliente;
        this.idPizza = idPizza;
        this.cantidad = cantidad;
        this.idEstado = idEstado;
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

    @Override
    public String toString() {
        return "Orden{" + "idOrden=" + idOrden + ", idCliente=" + idCliente + ", idPizza=" + idPizza + ", cantidad=" + cantidad + ", idEstado=" + idEstado + '}';
    }

}
