package servicio;


import dao.DueñoDao;
import entidad.Dueño;

import java.sql.SQLException;
import java.util.List;

public class DueñoServicio {
    private DueñoDao dueñoDao;

    public DueñoServicio() {
        this.dueñoDao = new DueñoDao();
    }

    public List<Dueño> obtenerDUEÑO() throws SQLException {
        return dueñoDao.obtenerDueño();
    }

    public void agregarDueño(Dueño dueño) throws SQLException {
        dueñoDao.agregarDueño(dueño);
    }
}
