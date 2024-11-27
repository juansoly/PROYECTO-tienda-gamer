package dao;

import entidad.Usuario;
import conectorDB.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class usuarioDAO {
    private Connection conexion;

    public usuarioDAO() {
        this.conexion = ConexionBD.getConexion();
    }

    public List<Usuario> obtenerUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Usuario usuario = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("contraseña")
            );
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public void agregarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO cliente (nombre, correo, contraseña) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conexion.prepareStatement(sql);
        pstmt.setString(1, usuario.getNombre());
        pstmt.setString(2, usuario.getCorreo());
        pstmt.setString(3, usuario.getContraseña());
        pstmt.executeUpdate();
    }
}
