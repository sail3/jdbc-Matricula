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
import java.io.*;

/**
 *
 * @author dev09
 */
public class Matricula {
AlumnoDAO Objeto = new AlumnoDAO();
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws IOException {
    try {
      BufferedReader lec = new BufferedReader(new InputStreamReader(System.in));  
      System.out.println("Primer proyecto en GIT.");//de tipo BufferedReader para que lea el codigo
      //System.out.println( AccesoDB.getConection() == null);
      AlumnoTO alumno = new AlumnoDAO().obtenerAlumno(1000);
      //System.out.println(alumno == null);
      //System.out.println(alumno.getCodigo());
      //System.out.println(alumno.getNombre());
      //System.out.println(alumno.getRecibo());
      System.out.println("Nuevo alumno insertado.\nLa clave del nuevo usuario es: " + new AlumnoDAO().registrarAlumno(new AlumnoTO("test03", "recibotest")));
      System.out.println("Menú de opciones:\n1. Editar un registro\n2. Salir\nElija una opcion:");
      int opcion=Integer.parseInt(lec.readLine());
              switch(opcion){
                  
                  case 1: //Editando un registro basandose en el codigo de alumno
                      //Pedimos por consola que se ingrese el codigo para obtener la informacion a traves de el
                      System.out.println("----------------------------------\nIngrese su codigo: ");
                      int codigo=Integer.parseInt(lec.readLine());
                      AlumnoTO alumnoAEditar = new AlumnoDAO().obtenerAlumno(codigo);
                      //Mostramos la inforacion del alumno con dicho codigo usando el objeto previamente creado
                      System.out.println("----------------------------------");
                      System.out.println("     Informacion del alumno:");
                      System.out.println("----------------------------------");
                      System.out.println("  Codigo:   "+alumnoAEditar.getCodigo());
                      System.out.println("  Nombre:   "+alumnoAEditar.getNombre());
                      System.out.println("  NºRecibo: "+alumnoAEditar.getRecibo());
                      System.out.println("----------------------------------");
                      //Y lanzamos la edicion, pedimos nuevo nombre y nuevo recibo
                      System.out.println("Ingrese nombre:");
                      String nuevoNombre=lec.readLine();
                      System.out.println("Ingrese recibo:");
                      String nuevoRecibo=lec.readLine();
                      //Llamamos al metodo editar
                      AlumnoTO alumno1 = new AlumnoDAO().editarAlumno(codigo, nuevoNombre, nuevoRecibo);
                      break;
                      
                  case 2://Detenemos la ejecucion del programa
                      System.exit(0);break;
                  
                  default: System.out.println("Opcion no valida!");
              }
      
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
