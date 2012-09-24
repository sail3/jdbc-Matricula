/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.core.to;

/**
 *
 * @author dev09
 */
public class MatriculaTO {
  private int codigo;
  private int alumnoCodigo;
  private int programacionCodigo;
  private String semestre;

  public MatriculaTO(int codigo, int alumnoCodigo, int programacionCodigo, String semestre) {
    this.codigo = codigo;
    this.alumnoCodigo = alumnoCodigo;
    this.programacionCodigo = programacionCodigo;
    this.semestre = semestre;
  }

  public MatriculaTO(int alumnoCodigo, int programacionCodigo, String semestre) {
    this.alumnoCodigo = alumnoCodigo;
    this.programacionCodigo = programacionCodigo;
    this.semestre = semestre;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public int getAlumnoCodigo() {
    return alumnoCodigo;
  }

  public void setAlumnoCodigo(int alumnoCodigo) {
    this.alumnoCodigo = alumnoCodigo;
  }

  public int getProgramacionCodigo() {
    return programacionCodigo;
  }

  public void setProgramacionCodigo(int programacionCodigo) {
    this.programacionCodigo = programacionCodigo;
  }

  public String getSemestre() {
    return semestre;
  }

  public void setSemestre(String semestre) {
    this.semestre = semestre;
  }
  
}
