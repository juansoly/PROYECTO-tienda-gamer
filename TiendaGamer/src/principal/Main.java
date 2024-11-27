package principal;

import controlador.ComponenteControlador;
import controlador.DueñoControlador;
import controlador.UsuarioControlador;
import entidad.Dueño;
import entidad.Usuario;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ComponenteControlador componenteControlador = new ComponenteControlador();
        DueñoControlador dueñoControlador = new DueñoControlador();
        UsuarioControlador usuarioControlador = new UsuarioControlador();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            Dueño dueñoActual = null;
            Usuario usuarioActual = null;

            // Proceso de registro o inicio de sesión
            while (dueñoActual == null && usuarioActual == null && !salir) {
                System.out.println("MENU PRINCIPAL :");
                System.out.println("1. Registrar dueño/administrador");
                System.out.println("2. Iniciar sesión como dueño/administrador");
                System.out.println("3. Registrar usuario");
                System.out.println("4. Iniciar sesión como usuario");
                System.out.println("5. Salir");

                int opcion = sc.nextInt();
                sc.nextLine();

                try {
                    switch (opcion) {
                        case 1:
                            dueñoActual = registrarDueño(dueñoControlador, sc);
                            break;
                        case 2:
                            dueñoActual = iniciarSesionDueño(dueñoControlador, sc);
                            break;
                        case 3:
                            usuarioActual = registrarUsuario(usuarioControlador, sc);
                            break;
                        case 4:
                            usuarioActual = iniciarSesionUsuario(usuarioControlador, sc);
                            break;
                        case 5:
                            System.out.println("Saliendo del programa.");
                            salir = true;
                            break;
                        default:
                            System.out.println("Opción no válida. Intente nuevamente.");
                    }
                } catch (SQLException e) {
                    System.err.println("Error al interactuar con la base de datos: " + e.getMessage());
                }
            }
            if (salir){
                break;
            }


            if (dueñoActual != null) {
                boolean continuar = true;
                while (continuar) {
                    System.out.println("Menú para administradores:");
                    System.out.println("1. Listar componentes");
                    System.out.println("2. Agregar componente");
                    System.out.println("3. eliminar componente");
                    System.out.println("4. eliminar Usuario");
                    System.out.println("5. VOLVER AL MENU PRINCIPAL");

                    int opcion = sc.nextInt();
                    sc.nextLine();

                    try {
                        switch (opcion) {
                            case 1:
                                componenteControlador.listarComponentes();
                                break;
                            case 2:
                                componenteControlador.agregarComponente();
                                break;
                            case 3:
                              eliminaromponentes(componenteControlador ,sc);
                                break;
                            case 4:
                                eliminarusuario(usuarioControlador,sc);
                                break;
                            case 5:

                                continuar = false;
                                break;
                            default:
                                System.out.println("Opción no válida. Intente nuevamente.");
                        }
                    } catch (SQLException e) {
                        System.err.println("Error al interactuar con la base de datos: " + e.getMessage());
                    }
                }
            }

            if (usuarioActual != null) {
                boolean continuar = true;
                while (continuar) {
                    System.out.println("Menú para usuarios:");
                    System.out.println("1. Listar componentes");
                    System.out.println("2. Comprar componente");
                    System.out.println("3. Volver al menú principal");

                    int opcion = sc.nextInt();
                    sc.nextLine();

                    try {
                        switch (opcion) {
                            case 1:
                                componenteControlador.listarComponentes();
                                break;
                            case 2:
                                System.out.println("Ingrese el ID del componente que quiere comprar:");
                                int componenteId = sc.nextInt();
                                sc.nextLine();
                                componenteControlador.comprarComponente(componenteId, usuarioActual);
                                break;
                            case 3:
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opción no válida. Intente nuevamente.");
                        }
                    } catch (SQLException e) {
                        System.err.println("Error al interactuar con la base de datos: " + e.getMessage());
                    }
                }
            }
        }
        sc.close();
    }

    private static Dueño registrarDueño(DueñoControlador dueñoControlador, Scanner sc) throws SQLException {
        System.out.println("Ingrese su nombre:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su correo:");
        String correo = sc.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contraseña = sc.nextLine();

        Dueño nuevoDueño = new Dueño(0, nombre, correo, contraseña);
        dueñoControlador.agregarDueño(nuevoDueño);
        System.out.println("Dueño registrado con éxito");
        return nuevoDueño;
    }

    private static Dueño iniciarSesionDueño(DueñoControlador dueñoControlador, Scanner sc) throws SQLException {
        System.out.println("Ingrese su correo:");
        String correo = sc.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contraseña = sc.nextLine();

        List<Dueño> dueños = dueñoControlador.obtenerDueño();
        for (Dueño dueño : dueños) {
            if (dueño.getCorreo().equals(correo) && dueño.getContraseña().equals(contraseña)) {
                System.out.println("Inicio de sesión exitoso");
                return dueño;
            }
        }

        System.out.println("Correo o contraseña incorrectos. Intente nuevamente.");
        return null;
    }

    private static Usuario registrarUsuario(UsuarioControlador usuarioControlador, Scanner sc) throws SQLException {
        System.out.println("Ingrese su nombre:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su correo:");
        String correo = sc.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contraseña = sc.nextLine();

        Usuario nuevoUsuario = new Usuario(0, nombre, correo, contraseña);
        usuarioControlador.agregarUsuario(nuevoUsuario);
        System.out.println("Usuario registrado con éxito");
        return nuevoUsuario;
    }

    private static Usuario iniciarSesionUsuario(UsuarioControlador usuarioControlador, Scanner sc) throws SQLException {
        System.out.println("Ingrese su correo:");
        String correo = sc.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contraseña = sc.nextLine();

        List<Usuario> usuarios = usuarioControlador.obtenerUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getCorreo().equals(correo) && usuario.getContraseña().equals(contraseña)) {
                System.out.println("Inicio de sesión exitoso");
                return usuario;
            }
        }

        System.out.println("Correo o contraseña incorrectos. Intente nuevamente.");
        return null;
    }
    private static void eliminaromponentes(ComponenteControlador componenteControlador,Scanner sc)throws SQLException{
        System.out.println("por favor ingrese el id del componente que quiere eliminar");
        int ID= sc.nextInt();
        sc.nextLine();
        componenteControlador.eliminarcomponente((ID));
        System.out.println("componente eliminado");



    }
    private   static  void  eliminarusuario(UsuarioControlador usuarioControlador, Scanner sc)throws SQLException{
        System.out.println("por favor ingrese el id del usuario que quiera eliminar");
        int ID=sc.nextInt();
        sc.nextLine();
        usuarioControlador.eliminarUsuario((ID));
        System.out.println("usuario eliminado");
    }
}
