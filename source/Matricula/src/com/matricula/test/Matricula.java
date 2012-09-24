/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.test;

import com.matricula.core.db.AccesoDB;
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
