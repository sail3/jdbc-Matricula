package com.matricula.test;

import com.matricula.core.dao.CursoDAO;
import com.matricula.core.to.CursoTO;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TestCursos {

    public static void main(String[] args) {
        int flag;//flag para controlar la salida del menú.
        CursoDAO dao = null;
        //Se crea el objeto Scanner para leer datos del teclado
        Scanner sc = new Scanner(System.in);
        try {
            dao = new CursoDAO();
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }

        do {
            //Se muestran las opciones del menú
            System.out.println("\n# Mantenimiento de Cursos - Menú:"
                    + "\n1. Crear Nuevo Curso"
                    + "\n2. Actualizar Datos de Curso"
                    + "\n3. Eliminar Curso"
                    + "\n4. Listar Cursos"
                    + "\n5. Salir"
                    + "\n¿Qué operación desea realizar?");
            int menu = sc.nextInt();
            flag = menu;
            switch (menu) {
                //Se escogio "Crear nuevo"
                //Se crea un nuevo Curso
                case 1:
                    try {
                        System.out.println("Ingrese el nombre del nuevo Curso:");
                        sc.nextLine();
                        String nombre = sc.nextLine();//Se lee el nombre del Curso
                        System.out.println("Ingrese la desrcripcion del nuevo Curso:");
                        String descripcion = sc.nextLine();//Se lee la descripcion
                        System.out.println("Ingrese el numero de creditos del nuevo Curso:");
                        int creditos = sc.nextInt();//Se lee el total de creditos
                        //Se crea el Transfer Object y se le asigna valores a sus campos
                        CursoTO obj = new CursoTO();
                        obj.setNombre(nombre);
                        obj.setDescripcion(descripcion);
                        obj.setCreditos(creditos);
                        int rowsAffected = dao.crear(obj);//Se crea un nuevo Curso
                        System.out.println("Inserción Exitosa\n" + rowsAffected + " fila insertada.");
                    } catch (Exception ex) {
                        System.err.println("Error: " + ex.getMessage());
                    }
                    break;
                //Se escogio "Actualizar Datos"
                //Se actualizan los datos de un Curso existente
                case 2:
                    try {
                        System.out.println("Ingrese el codigo del Curso:");
                        int codigo = sc.nextInt();
                        System.out.println("Ingrese el nuevo nombre del Curso:");
                        sc.nextLine();
                        String nombre = sc.nextLine();
                        System.out.println("Ingrese la nueva descripcion del Curso:");
                        String descripcion = sc.nextLine();
                        System.out.println("Ingrese la nueva cantidad de creditos del Curso:");
                        int creditos = sc.nextInt();
                        CursoTO obj = new CursoTO();
                        obj.setCodigo(codigo);
                        obj.setNombre(nombre);
                        obj.setDescripcion(descripcion);
                        obj.setCreditos(creditos);
                        int rowsAffected = dao.actualizar(obj);//Se actualizan los datos
                        System.out.println("Actualización Exitosa\n" + rowsAffected + " fila actualizada.");
                    } catch (Exception ex) {
                        System.err.println("Error: " + ex.getMessage());
                    }
                    break;
                //Se escogio "Eliminar"
                //Se elimina un Curso.
                case 3:
                    try {
                        System.out.println("Ingrese el código del Curso:");
                        int codigo = sc.nextInt();
                        int rowsAffected = dao.eliminar(codigo);//Se elimina el Curso
                        if (rowsAffected == 0) {//Si no hay registros eliminados
                            System.err.println("Código no encontrado.");
                        } else {//Si hay uno o más registros eliminados
                            System.out.println("Eliminación Exitosa\n" + rowsAffected + " fila suprimida.");
                        }
                    } catch (Exception ex) {
                        System.err.println("Error: " + ex.getMessage());
                    }
                    break;
                //Se escogio "Listar"
                //Se listan los Cursos.
                case 4:
                    try {
                        List lista = dao.findAll();
                        Iterator it = lista.iterator();
                        while (it.hasNext()) {
                            CursoTO registro;
                            registro = (CursoTO) it.next();
                            System.out.println(registro);
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