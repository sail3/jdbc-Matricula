package com.matricula.core.interfaces;

import java.sql.SQLException;

/**
 * Interface que define las operaciones de persistencia CRUD (create, retrieve,
 * update and delete)
 *
 * @param <T> tipo del Objeto a mantener.
 * @param <K> tipo del código identificador del objeto.
 * @author Gustavo Fernández
 */
public interface Maintanable<T, K> {

    /**
     *
     * @param obj un objeto de tipo T.
     * @return un int que representa el número de filas afectadas, devuelve 1 si
     * la inserción fue exitosa, en caso contrario devuelve 0.
     * @throws SQLException
     */
    int create(T obj) throws SQLException;

    /**
     *
     * @param key el codigo identificador del registro en la base de datos.
     * @return un objeto de tipo T.
     * @throws SQLException
     */
    T retrieve(K key) throws SQLException;

    /**
     *
     * @param obj el objeto T con los datos que se desean actualizar.
     * @return un int que representa el número de filas afectadas. Devuelve 0 si
     * no se encontro el registro a actualizar.
     * @throws SQLException
     */
    int update(T obj) throws SQLException;

    /**
     *
     * @param key el codigo identificador del registro en la base de datos.
     * @return un int que representa el número de filas afectadas. Devuelve 0 si
     * no se encontro el registro a eliminar.
     * @throws SQLException
     */
    int delete(K key) throws SQLException;
}