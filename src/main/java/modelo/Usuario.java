package modelo;

import java.io.Serializable;


public class Usuario implements Serializable{
    
    private int idUsuario;
    private int idCliente;
    private String usuario;
    private String password;

    public Usuario() {
    }

    public Usuario(int idUsuario, int idCliente, String usuario, String password) {
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
        this.usuario = usuario;
        this.password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", idCliente=" + idCliente + ", usuario=" + usuario + ", password=" + password + '}';
    }
    
}
