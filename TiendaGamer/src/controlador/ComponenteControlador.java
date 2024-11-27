package controlador;

import entidad.Componente;
import entidad.Usuario;
import servicio.ComponenteServicio;
import vista.ComponenteVista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Scanner;

public class ComponenteControlador {

    private ComponenteServicio componenteServicio;
    private ComponenteVista componenteVista;

    public ComponenteControlador() {
        this.componenteServicio = new ComponenteServicio();
        this.componenteVista = new ComponenteVista();
    }

    public void listarComponentes() throws SQLException {
        componenteVista.mostrarComponentes(componenteServicio.obtenerComponentes());
    }

    public void agregarComponente() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del componente:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el fabricante del componente:");
        String fabricante = sc.nextLine();
        System.out.println("Ingrese la marca del componente:");
        String marca = sc.nextLine();
        System.out.println("Ingrese la descripción del componente:");
        String descripcion = sc.nextLine();
        System.out.println("Ingrese el precio del componente:");
        double precio = sc.nextDouble();

        Componente nuevoComponente = new Componente(0, nombre, fabricante, marca, descripcion, precio);
        componenteServicio.agregarComponente(nuevoComponente);
        System.out.println("Componente agregado ");
    }
    public void eliminarcomponente(int id) throws SQLException {
        componenteServicio.eliminarcomponente(id);
    }




    public void comprarComponente(int componenteId, Usuario usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendaGAMER", "root", "");

            String query = "INSERT INTO registrocompras (usuarioId, componenteId, fechaCompra) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setInt(1, usuario.getId());
            ps.setInt(2, componenteId);
            ps.setTimestamp(3, Timestamp.from(Instant.now()));

            ps.executeUpdate();
            System.out.println("Compra registrada con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al registrar la compra: " + e.getMessage());
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


