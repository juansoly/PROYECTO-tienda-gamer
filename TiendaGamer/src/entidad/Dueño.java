package entidad;



public class Dueño {
    private int id;
    private String nombre;
    private String correo;
    private String contraseña;

    // Constructor, getters y setters
    public Dueño(int id, String nombre, String correo, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }
}
