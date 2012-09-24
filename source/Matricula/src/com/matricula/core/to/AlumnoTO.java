/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.core.to;

/**
 *
 * @author dev09
 */
public class AlumnoTO {
  private int codigo;
  private String nombre;
  private String recibo;

  public AlumnoTO(int codigo, String nombre, String recibo) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.recibo = recibo;
  }

  public AlumnoTO(String nombre, String recibo) {
    this.nombre = nombre;
    this.recibo = recibo;
  }

  public AlumnoTO() {
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

  public String getRecibo() {
    return recibo;
  }

  public void setRecibo(String recibo) {
    this.recibo = recibo;
  }
  
}
