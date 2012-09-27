/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.core.dao;

import com.matricula.core.db.AccesoDB;
import com.matricula.core.to.AlumnoTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dev09
 */
public class AlumnoDAO {
  
  /**
   * Este metodo realiza una consulta a la tabla alumno.
   * 
   * @param codigo criterio de filtrado para la cosulta, segun sea codigo.
   * @return retorta un objeto de tipo alumno con los datos rescatados de la base de datos.
   * @throws SQLException
   * @throws InstantiationException
   * @throws ClassNotFoundException
   * @throws IllegalAccessException 
   */
  public AlumnoTO obtenerAlumno(int codigo) throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException {
    String sql = "SELECT * FROM Alumno WHERE int_alumid = ?";
    PreparedStatement pst = AccesoDB.getConection().prepareStatement(sql);
    ResultSet cdr = null;
    pst.setInt(1, codigo);
    cdr = pst.executeQuery();
    AlumnoTO alumno = null;
    while (cdr.next()) {
      alumno = new AlumnoTO();
      alumno.setCodigo(cdr.getInt(1));
      alumno.setNombre(cdr.getString(2));
      alumno.setRecibo(cdr.getString(3));
    }
    return alumno;
  }
  
  public void MensajeNuevo(){
      System.out.println("Este es un metodo nuevo");
  }
  
  /**
   * Este metodo registra un alumno a la base de datos
   * 
   * @param alumno Objeto de tipo alumno con los valores a insertar a la base de datos.
   * @return Retorna un entero con la clave del nuevo alumno generado.
   * @throws InstantiationException
   * @throws IllegalAccessException
   * @throws ClassNotFoundException
   * @throws SQLException 
   */
  public int registrarAlumno(AlumnoTO alumno) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    int codigo = 0;
    String sql = "INSERT INTO Alumno VALUES (null, ?, ?)";
    ResultSet cdr = null;
    PreparedStatement ps = AccesoDB.getConection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
    ps.setString(1, alumno.getNombre());
    ps.setString(2, alumno.getRecibo());
    ps.executeUpdate();
    cdr = ps.getGeneratedKeys();
    while (cdr.next()) {
      codigo = cdr.getInt(1);
    }
    return codigo;
  }

  /**
   * Este metodo elimina un registro de la base de datos.
   * 
   * @param alumno objeto del cual se le extrae el codigo de alumno.
   * @throws InstantiationException
   * @throws IllegalAccessException
   * @throws ClassNotFoundException
   * @throws SQLException 
   */
  public void eliminarAlumno(AlumnoTO alumno) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    String sql = "DELETE FROM Alumno WHERE int_alumid = ?";
    ResultSet cdr = null;
    PreparedStatement ps = AccesoDB.getConection().prepareStatement(sql);
    ps.setInt(1, alumno.getCodigo());
    ps.executeUpdate();
  }

}

