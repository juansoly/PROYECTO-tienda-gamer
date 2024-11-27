package vista;

import entidad.Usuario;

import java.util.List;

public class UsuarioVista {
    public void mostrarUsuarios(List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Correo: " + usuario.getCorreo());
            System.out.println();
        }
    }
}
