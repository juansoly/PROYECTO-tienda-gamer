package vista;



import entidad.Componente;

import java.util.List;

public class ComponenteVista {
    public void mostrarComponentes(List<Componente> componentes) {
        for (Componente componente : componentes) {
            System.out.println("ID: " + componente.getId());
            System.out.println("Nombre: " + componente.getNombre());
            System.out.println("Fabricante: " + componente.getFabricante());
            System.out.println("Marca: " + componente.getMarca());
            System.out.println("Descripción: " + componente.getDescripcion());
            System.out.println("precio"+componente.getPrecio());
            System.out.println();
        }
    }
}
