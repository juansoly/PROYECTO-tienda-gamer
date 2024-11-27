package dao;

import entidad.Componente;
import conectorDB.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComponenteDAO {
    private Connection conexion;

    public ComponenteDAO() {
        this.conexion = ConexionBD.getConexion();
    }
    public List<Componente> obtenerComponentes() throws SQLException {
        List<Componente> componentes = new ArrayList<>();
        String sql = "SELECT * FROM componentes";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Componente componente = new Componente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("fabricante"),
                    rs.getString("marca"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio")
            );
            componentes.add(componente);
        }
        return componentes;
    }

    public void agregarComponente(Componente componente) throws SQLException {
        String sql = "INSERT INTO componentes (nombre, fabricante, marca, descripcion,precio) VALUES (?, ?, ?, ?,?)";
        PreparedStatement pstmt = conexion.prepareStatement(sql);
        pstmt.setString(1, componente.getNombre());
        pstmt.setString(2, componente.getFabricante());
        pstmt.setString(3, componente.getMarca());
        pstmt.setString(4, componente.getDescripcion());
        pstmt.setDouble(5, componente.getPrecio());
        pstmt.executeUpdate();
    }
}
