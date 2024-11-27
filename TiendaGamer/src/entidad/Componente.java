package entidad;



public class Componente {
    private int id;
    private String nombre;
    private String fabricante;
    private String marca;
    private String descripcion;
    private  double precio;

    // Constructor, getters y setters


    public Componente(int id, String nombre, String fabricante, String marca, String descripcion, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getMarca() {
        return marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }
}

