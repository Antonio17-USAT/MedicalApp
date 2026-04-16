package pe.edu.usat.medicalapp.modelo;

import androidx.annotation.NonNull;

public class Especialidad {
    private String nombre;
    private String descripcion;
    private int imagen;

    public Especialidad(String nombre, String descripcion, int imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @NonNull
    @Override
    public String toString() {
        return nombre;
    }
}
