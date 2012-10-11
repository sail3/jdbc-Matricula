package com.matricula.test;

import com.matricula.core.dao.AlumnoDAO;
import com.matricula.core.to.AlumnoTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dev09
 */
public class Matricula {

    AlumnoDAO Objeto = new AlumnoDAO();

    /**
     * @param args the command line arguments
     * @throws IOException
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
            int opcion = Integer.parseInt(lec.readLine());//Leemos la opcion y jugamos con el switch

            switch (opcion) {

                case 1://Creando un registro
                    System.out.println("----------------------------------");
                    System.out.println("  Ingrese informacion del alumno");
                    System.out.println("----------------------------------");//Pedimos los datos
                    System.out.println("Ingrese nombre:");
                    String nombre = lec.readLine();
                    System.out.println("Ingrese recibo:");
                    String recibo = lec.readLine();
                    //Llamamos al metodo registrar
                    new AlumnoDAO().crear(new AlumnoTO(nombre, recibo));
                    System.out.println("----------------------------------");
                    System.out.println("Registro creado!");
                    break;

                case 2: //Editando un registro
                    System.out.println("Ingrese su codigo: ");
                    int codigo = Integer.parseInt(lec.readLine());//Leemos el codigo
                    AlumnoTO a = new AlumnoDAO().recuperar(codigo);//Obtenemos la informacion del alumno
                    System.out.println("----------------------------------");//Mostramos la informacion del alumno
                    System.out.println("Codigo Actual:" + a.getCodigo() + "\nNombre Actual:" + a.getNombre() + "\nRecibo Actual:" + a.getRecibo());
                    System.out.println("----------------------------------");
                    System.out.println("Nuevo nombre:");
                    String nuevoNombre = lec.readLine();
                    System.out.println("Nuevo recibo:");
                    String nuevoRecibo = lec.readLine();
                    //Llamamos al metodo editar
                    new AlumnoDAO().actualizar(new AlumnoTO(codigo, nuevoNombre, nuevoRecibo));
                    System.out.println("----------------------------------");
                    System.out.println("Registro editado!");
                    break;

                case 3:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion no valida!");

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
