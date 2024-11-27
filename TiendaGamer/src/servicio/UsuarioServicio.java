package servicio;

import dao.usuarioDAO;
import entidad.Usuario;

import java.sql.SQLException;
import java.util.List;

public class UsuarioServicio {
    private usuarioDAO usuarioDAO;

    public UsuarioServicio() {
        this.usuarioDAO = new usuarioDAO();
    }

    public List<Usuario> obtenerUsuarios() throws SQLException {
        return usuarioDAO.obtenerUsuarios();
    }

    public void agregarUsuario(Usuario usuario) throws SQLException {
        usuarioDAO.agregarUsuario(usuario);
    }
}
