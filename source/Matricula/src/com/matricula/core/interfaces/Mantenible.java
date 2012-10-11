package com.matricula.core.interfaces;

import java.sql.SQLException;

/**
 * Interface que define las operaciones de persistencia CRUD (create, retrieve,
 * update and delete) - Crear, recuperar, actualizar y eliminar.
 *
 * @param <T> tipo del Objeto a mantener.
 * @param <K> tipo del código identificador del objeto.
 * @author Gustavo Fernández
 */
public interface Mantenible<T, K> {

    /**
     *
     * @param obj un objeto de tipo T.
     * @return un int que representa el número de filas afectadas, devuelve 1 si
     * la inserción fue exitosa, en caso contrario devuelve 0.
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    int crear(T obj) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;

    /**
     *
     * @param key el codigo identificador del registro en la base de datos.
     * @return un objeto de tipo T.
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    T recuperar(K key) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;

    /**
     *
     * @param obj el objeto T con los datos que se desean actualizar.
     * @return un int que representa el número de filas afectadas. Devuelve 0 si
     * no se encontro el registro a actualizar.
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    int actualizar(T obj) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;

    /**
     *
     * @param key el codigo identificador del registro en la base de datos.
     * @return un int que representa el número de filas afectadas. Devuelve 0 si
     * no se encontro el registro a eliminar.
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    int eliminar(K key) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
}