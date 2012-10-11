package com.matricula.test;

import com.matricula.core.dao.ProfesorDAO;
import com.matricula.core.to.ProfesorTO;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gustavo Fernández
 */
public class TestProfesor {

    public static void main(String[] args) {
        int flag;
        ProfesorDAO dao = null;
        Scanner in = new Scanner(System.in);//Objeto Scanner para leer datos del teclado
        try {
            dao = new ProfesorDAO();
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }

        do {
            //Se muestran las opciones del menú
            System.out.println("\nMantenimiento de Profesores - Menú:"
                    + "\n1. Crear Nuevo"
                    + "\n2. Actualizar Datos"
                    + "\n3. Eliminar"
                    + "\n4. Listar"
                    + "\n5. Salir"
                    + "\n¿Qué operación desea realizar?");
            int menu = in.nextInt();
            flag = menu;
            switch (menu) {
                //Se escogio "Crear nuevo"
                //Se inserta un nuevo Profesor
                case 1:
                    try {
                        System.out.println("Ingrese el nombre del nuevo profesor");
                        String nombre = in.next();//Se lee el nombre
                        System.out.println("Ingrese el titulo del nuevo profesor");
                        String titulo = in.next();//Se lee el título
                        ProfesorTO obj = new ProfesorTO();
                        obj.setNombre(nombre);
                        obj.setTitulo(titulo);
                        int rowsAffected = dao.crear(obj);//Se inserta un nuevo profesor
                        System.out.println("Inserción Exitosa\n" + rowsAffected + " fila insertada");
                    } catch (Exception ex) {
                        System.err.println("Error: " + ex.getMessage());
                    }
                    break;
                //Se escogio "Actualizar Datos"
                //Se actualizan los datos de un profesor existente
                case 2:
                    try {
                        System.out.println("Ingrese el codigo del profesor:");
                        int codigo = in.nextInt();
                        System.out.println("Ingrese el nuevo nombre del profesor");
                        String nombre = in.next();
                        System.out.println("Ingrese el nuevo titulo del profesor");
                        String titulo = in.next();
                        ProfesorTO obj = new ProfesorTO();
                        obj.setCodigo(codigo);
                        obj.setNombre(nombre);
                        obj.setTitulo(titulo);
                        int rowsAffected = dao.actualizar(obj);//Se actualizan los datos
                        System.out.println("Actualización Exitosa\n" + rowsAffected + " fila actualizada");
                    } catch (Exception ex) {
                        System.err.println("Error: " + ex.getMessage());
                    }
                    break;
                //Se escogio "Eliminar"
                //Se elimina a un profesor.
                case 3:
                    try {
                        System.out.println("Ingrese el codigo del profesor:");
                        int codigo = in.nextInt();
                        int rowsAffected = dao.eliminar(codigo);//Se elimina el profesor
                        if (rowsAffected == 0) {//Si no hay registros eliminados
                            System.err.println("Códgio no encontrado.");
                        } else {//Si hay uno o más registros eliminados
                            System.out.println("Eliminación Exitosa\n" + rowsAffected + " fila suprimida");
                        }
                    } catch (Exception ex) {
                        System.err.println("Error: " + ex.getMessage());
                    }
                    break;
                //Se escogio "Listar"
                //Se listan los profesores
                case 4:
                    try {
                        List lista = dao.listarTodos();
                        Iterator it = lista.iterator();
                        while (it.hasNext()) {
                            ProfesorTO reg;
                            reg = (ProfesorTO) it.next();
                            System.out.println(reg);
                        }
                    } catch (SQLException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }

                    break;
            }
        } while (flag != 5);/*
         * Mientras no se escoga la opcion 5 "Salir" seguira el loop, caso
         * contrario finaliza el loop y la aplicación.
         */
    }
}
