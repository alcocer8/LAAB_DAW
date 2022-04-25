package modelo;

public class Empleado {
    private int id;
    private String usuario;
    private String password;
    private String nombre;
    private String apellido;
    private int puesto;

    public Empleado() {
    }

    public Empleado(int id, String usuario, String password, String nombre, String apellido, int puesto) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", usuario=" + usuario + ", password=" + password + ", nombre=" + nombre + ", apellido=" + apellido + ", puesto=" + puesto + '}';
    }
    
    
}
