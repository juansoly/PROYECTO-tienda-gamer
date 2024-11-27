package vista;



import entidad.Dueño;

import java.util.List;

public class DueñoVista {
    public void mostrarDueño(List<Dueño> usuarios) {
        for (Dueño usuario : usuarios) {
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Correo: " + usuario.getCorreo());
            System.out.println();
        }
    }
}
