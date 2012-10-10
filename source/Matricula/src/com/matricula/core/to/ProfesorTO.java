package com.matricula.core.to;

/**
 *
 * @author dev09
 */
public class ProfesorTO {

    private int codigo;
    private String nombre;
    private String titulo;

    public ProfesorTO(int codigo, String nombre, String titulo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.titulo = titulo;
    }

    public ProfesorTO(String nombre, String titulo) {
        this.nombre = nombre;
        this.titulo = titulo;
    }

    public ProfesorTO() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "ProfesorTO{" + "codigo=" + codigo + ", nombre=" + nombre + ", titulo=" + titulo + '}';
    }
}
