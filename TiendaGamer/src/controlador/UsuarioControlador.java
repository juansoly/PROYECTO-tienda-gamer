package controlador;

import entidad.Usuario;
import servicio.UsuarioServicio;
import vista.UsuarioVista;

import java.sql.SQLException;
import java.util.List;

public class UsuarioControlador {
    private UsuarioServicio usuarioServicio;
    private UsuarioVista usuarioVista;

    public UsuarioControlador() {
        this.usuarioServicio = new UsuarioServicio();
        this.usuarioVista = new UsuarioVista();
    }

    public void listarUsuarios() throws SQLException {
        usuarioVista.mostrarUsuarios(usuarioServicio.obtenerUsuarios());
    }

    public void agregarUsuario(Usuario usuario) throws SQLException {
        usuarioServicio.agregarUsuario(usuario);
    }

    public List<Usuario> obtenerUsuarios() throws SQLException {
        return usuarioServicio.obtenerUsuarios();
    }
    public  void eliminarUsuario(int id)throws SQLException{

    }
}
