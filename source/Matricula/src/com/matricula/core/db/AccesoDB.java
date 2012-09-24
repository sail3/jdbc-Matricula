/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.core.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dev09
 */
public class AccesoDB {
  private static Connection conexion = null;
  public static Connection getConection() throws InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException{
    
    if (conexion == null) {
      String url = "jdbc:mysql://localhost/DB_matricula";
      String pass = "root";
      String user = "root";
      String driver = "com.mysql.jdbc.Driver";
      Class.forName(driver).newInstance();
      conexion = DriverManager.getConnection(url, user, pass);
    }
    return conexion;
  }
  
}
