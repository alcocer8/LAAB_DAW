package modelo;
public class Puesto {

    private int idPuesto;
    private String descripcion;

    public Puesto() {
    }

    public Puesto(int idPuesto, String descripcion) {
        this.idPuesto = idPuesto;
        this.descripcion = descripcion;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Puesto{" + "idPuesto=" + idPuesto + ", descripcion=" + descripcion + '}';
    }

}
