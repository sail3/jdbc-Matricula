/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.core.to;

/**
 *
 * @author dev09
 */
public class CursoTO {
  private int codigo;
  private String nombre;
  private String descripcion;
  private int creditos;

  public CursoTO(int codigo, String nombre, String descripcion, int creditos) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.creditos = creditos;
  }

  public CursoTO(String nombre, String descripcion, int creditos) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.creditos = creditos;
  }

  public CursoTO() {
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
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

  public int getCreditos() {
    return creditos;
  }

  public void setCreditos(int creditos) {
    this.creditos = creditos;
  }
  
}
