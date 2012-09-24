/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.core.to;

/**
 *
 * @author dev09
 */
public class ProgramacionTO {
  private int codigo;
  private int cursoCodigo;
  private int profesorCodigo;
  private String horario;

  public ProgramacionTO(int codigo, int cursoCodigo, int profesorCodigo, String horario) {
    this.codigo = codigo;
    this.cursoCodigo = cursoCodigo;
    this.profesorCodigo = profesorCodigo;
    this.horario = horario;
  }

  public ProgramacionTO(int cursoCodigo, int profesorCodigo, String horario) {
    this.cursoCodigo = cursoCodigo;
    this.profesorCodigo = profesorCodigo;
    this.horario = horario;
  }

  public ProgramacionTO() {
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public int getCursoCodigo() {
    return cursoCodigo;
  }

  public void setCursoCodigo(int cursoCodigo) {
    this.cursoCodigo = cursoCodigo;
  }

  public int getProfesorCodigo() {
    return profesorCodigo;
  }

  public void setProfesorCodigo(int profesorCodigo) {
    this.profesorCodigo = profesorCodigo;
  }

  public String getHorario() {
    return horario;
  }

  public void setHorario(String horario) {
    this.horario = horario;
  }
  
  
}
