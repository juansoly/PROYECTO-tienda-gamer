package dao;


import entidad.Dueño;
import conectorDB.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DueñoDao {
    private Connection conexion;

    public DueñoDao() {
        this.conexion = ConexionBD.getConexion();
    }

    public List<Dueño> obtenerDueño() throws SQLException {
        List<Dueño> dueños = new ArrayList<>();
        String sql = "SELECT * FROM administrador";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Dueño dueño = new Dueño(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("contraseña")
            );
            dueños.add(dueño);
        }
        return dueños;
    }

    public void agregarDueño(Dueño dueño) throws SQLException {
        String sql = "INSERT INTO administrador (nombre, correo, contraseña) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conexion.prepareStatement(sql);
        pstmt.setString(1, dueño.getNombre());
        pstmt.setString(2, dueño.getCorreo());
        pstmt.setString(3, dueño.getContraseña());
        pstmt.executeUpdate();
    }
}
