/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.test;

import com.matricula.core.dao.AlumnoDAO;
import com.matricula.core.db.AccesoDB;
import com.matricula.core.to.AlumnoTO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dev09
 */
public class Matricula {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    try {
      System.out.println("primer proyecto en GIT.");
      System.out.println( AccesoDB.getConection() == null);
      AlumnoTO alumno = new AlumnoDAO().obtenerAlumno(1000);
      System.out.println(alumno == null);
      System.out.println(alumno.getCodigo());
      System.out.println(alumno.getNombre());
      System.out.println(alumno.getRecibo());
      System.out.println("insertardo alumno.......");
      System.out.println("la clave del nuevo usuario es: " + new AlumnoDAO().registrarAlumno(new AlumnoTO("test03", "recibotest")));
      new AlumnoDAO().MensajeNuevo();
    } catch (InstantiationException ex) {
      Logger.getLogger(Matricula.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(Matricula.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(Matricula.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Matricula.class.getName()).log(Level.SEVERE, null, ex);
    }
    
  }
}
