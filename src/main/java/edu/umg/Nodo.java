package edu.umg;

public class Nodo {
    private Telefono telefono;
    private Nodo siguiente;

    // Constructor
    public Nodo(Telefono telefono) {
        this.telefono = telefono;
        this.siguiente = null; // Inicialmente el siguiente nodo es null
    }

    // Getters y setters
    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    // Método para verificar si el nodo tiene un siguiente nodo
    public boolean tieneSiguiente() {
        return siguiente != null;
    }

    // Método para obtener una representación String del nodo
    @Override
    public String toString() {
        return telefono.toString();
    }
}
