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
      //Se crea una lectora de datos de tipo BufferedReader  
      BufferedReader lec = new BufferedReader(new InputStreamReader(System.in));  
      System.out.println("Primer proyecto en GIT.");
      System.out.println("----------------------------------");
      System.out.println("Menú de opciones:");//Mostramos las tres opciones de nuestro menú
      System.out.println("1.--Crear un registro\n2.--Editar un registro\n3.--Salir");
      System.out.println("----------------------------------");
      System.out.println("Elija una opcion:");
      int opcion=Integer.parseInt(lec.readLine());//Leemos la opcion y jugamos con el switch
              
      switch(opcion){
                  
                  case 1://Creando un registro
                      System.out.println("----------------------------------");
                      System.out.println("  Ingrese informacion del alumno");
                      System.out.println("----------------------------------");
                      System.out.println("Ingrese nombre:");//Pedimos los datos
                      String nombre=lec.readLine();
                      System.out.println("Ingrese recibo:");
                      String recibo=lec.readLine();//Guardamos los datos en la BD
                      new AlumnoDAO().registrarAlumno(new AlumnoTO(nombre, recibo));
                      break;
                      
                  case 2: //Editando un registro
                      System.out.println("----------------------------------\nIngrese su codigo: ");
                      int codigo=Integer.parseInt(lec.readLine());//Leemos el codigo
                      AlumnoTO alumnoAEditar = new AlumnoDAO().obtenerAlumno(codigo);
                      //Mostramos la inforacion del alumno con el codigo que pedimos
                      System.out.println("----------------------------------");
                      System.out.println("Informacion del alumno encontrado");
                      System.out.println("----------------------------------");
                      System.out.println("  Codigo:   "+alumnoAEditar.getCodigo());
                      System.out.println("  Nombre:   "+alumnoAEditar.getNombre());
                      System.out.println("  NºRecibo: "+alumnoAEditar.getRecibo());
                      System.out.println("----------------------------------");
                      System.out.println("Ingrese nuevo nombre:");//Pedimos los datos nuevos
                      String nuevoNombre=lec.readLine();
                      System.out.println("Ingrese nuevo recibo:");
                      String nuevoRecibo=lec.readLine();//Llamamos al metodo editar
                      new AlumnoDAO().editarAlumno(codigo, nuevoNombre, nuevoRecibo);
                      break;
                      
                  case 3:
                      System.exit(0);
                      break;
                  
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
