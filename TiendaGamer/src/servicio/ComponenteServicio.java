package servicio;



import dao.ComponenteDAO;
import entidad.Componente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ComponenteServicio {
    private ComponenteDAO componenteDAO;

    public ComponenteServicio() {
        this.componenteDAO = new ComponenteDAO();
    }

    public List<Componente> obtenerComponentes() throws SQLException {
        return componenteDAO.obtenerComponentes();
    }

    public void agregarComponente(Componente Componente) throws SQLException {
        componenteDAO.agregarComponente(Componente);
    }
    public void eliminarcomponente(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendaGAMER", "root", "");
            String query = "DELETE FROM componentes WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar el componente: " + e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }


}
