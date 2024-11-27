package controlador;



import entidad.Dueño;
import servicio.DueñoServicio;
import vista.DueñoVista;

import java.sql.SQLException;
import java.util.List;

public class DueñoControlador {
    private DueñoServicio dueñoServicio;
    private DueñoVista dueñoVista;

    public DueñoControlador() {
        this.dueñoServicio = new DueñoServicio();
        this.dueñoVista = new DueñoVista();
    }

    public void listarDueños() throws SQLException {
        dueñoVista.mostrarDueño(dueñoServicio.obtenerDUEÑO());
    }

    public void agregarDueño(Dueño dueño) throws SQLException {
        dueñoServicio.agregarDueño(dueño);
    }

    public List<Dueño> obtenerDueño() throws SQLException {
        return dueñoServicio.obtenerDUEÑO();
    }
}
