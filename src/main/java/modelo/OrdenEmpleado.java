package modelo;

import java.io.Serializable;

public class OrdenEmpleado implements Serializable{

    private int id;
    private int idOrden;
    private int idEmpleado;
    private int estado;

    public OrdenEmpleado() {
    }

    public OrdenEmpleado(int id, int idOrden, int idEmpleado, int estado) {
        this.id = id;
        this.idOrden = idOrden;
        this.idEmpleado = idEmpleado;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "OrdenEmpleado{" + "id=" + id + ", idOrden=" + idOrden + ", idEmpleado=" + idEmpleado + ", estado=" + estado + '}';
    }

}
